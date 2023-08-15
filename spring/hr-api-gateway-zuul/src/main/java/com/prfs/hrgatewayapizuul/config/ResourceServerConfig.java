package com.prfs.hrgatewayapizuul.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private JwtTokenStore jTStore;

	// Fazer autenticação - token
	private static final String[] PUBLIC = { "/hr-oauth/oauth/token" };

	// Autorização para operador
	private static final String[] OPERATOR = { "/hr-worker/**" };

	// Perfil de admin
	private static final String[] ADMIN = { "/hr-payroll/**", "/hr-user/**", "/actuator/**", "/hr-worker/actuator/**",
			"/hr-oauth/actuator/**" };

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(jTStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// Todos os caminhos definido no vetor PUBLIC vai ter permissão para acessar
		// mesmo não estando logado
		http.authorizeRequests(requests -> requests.antMatchers(PUBLIC).permitAll()
				.antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR", "ADMIN").antMatchers(ADMIN)
				.hasAnyRole("ADMIN").anyRequest().authenticated());

		// Autorizando requisições GET
		// Somente o que estiver no vetor OPERATOR poderá ter acesso e somente no metodo
		// GET
		
		http.cors().configurationSource(cC());
	}

	@Bean
	public CorsConfigurationSource cC() { // cC corsConfiguration
		CorsConfiguration cc1 = new CorsConfiguration();
		cc1.setAllowedOrigins(Arrays.asList("*"));
		cc1.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "PATCH"));
		cc1.setAllowCredentials(true);
		cc1.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

		UrlBasedCorsConfigurationSource uBCCSource = new UrlBasedCorsConfigurationSource();
		uBCCSource.registerCorsConfiguration("/**", cc1);
		return uBCCSource;
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> cF() { //cF corsFilter
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(cC()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE); // Precendencia mais alta
		return bean;
	}

}

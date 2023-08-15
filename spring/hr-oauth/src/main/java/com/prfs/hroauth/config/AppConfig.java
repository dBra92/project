package com.prfs.hroauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

//extends WebSecurityConfigurerAdapter
@Configuration
public class AppConfig  {
	
	@Value("${jwt.secret}")
	private String jwtSecretOAuth;
	
	// Aula 41 - Login e Tokek pt 1
	@Bean
	public BCryptPasswordEncoder bCPEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtAccessTokenConverter jATConverter() {
		JwtAccessTokenConverter tConverter = new JwtAccessTokenConverter();
		tConverter.setSigningKey(jwtSecretOAuth);
		return tConverter;
	}

	@Bean
	public JwtTokenStore tStore() {
		return new JwtTokenStore(jATConverter());
	}
/*
	// Solução para aula 40 - UserFeignClient
	@Override
	public void configure(HttpSecurity http) throws Exception {
	// @formatter:off

    http

        .csrf()

        .disable()

        .exceptionHandling()

    .and()

        .authorizeRequests()

        .antMatchers("/hr-oauth/**").permitAll();

    // @formatter:on

	}
*/
}
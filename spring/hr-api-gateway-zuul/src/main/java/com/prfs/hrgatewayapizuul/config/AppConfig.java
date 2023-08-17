package com.prfs.hrgatewayapizuul.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@RefreshScope //Atualizar os valores das variaveis
@Configuration
public class AppConfig {
	
	//@Value("${jwt.secret}")
	//private String jSecret;
	
	@Bean
	JwtAccessTokenConverter jATConverter() {
		JwtAccessTokenConverter tConverter = new JwtAccessTokenConverter();
		//tConverter.setSigningKey(jSecret);
		return tConverter;
	}

	@Bean
	JwtTokenStore tStore() {
		return new JwtTokenStore(jATConverter());
	}
}

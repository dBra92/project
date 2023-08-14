package com.prfs.hrgatewayapizuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {

	@Bean
	JwtAccessTokenConverter jATConverter() {
		JwtAccessTokenConverter tConverter = new JwtAccessTokenConverter();
		tConverter.setSigningKey("MY-SECRET-KEY");
		return tConverter;
	}

	@Bean
	JwtTokenStore tStore() {
		return new JwtTokenStore(jATConverter());
	}
}

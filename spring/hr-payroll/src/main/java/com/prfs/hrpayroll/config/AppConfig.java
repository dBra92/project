package com.prfs.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig { // Classe de configuração; cod de config, disp algumas instancias de objetos

	// Comunicar um com outro usando restTemplate

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

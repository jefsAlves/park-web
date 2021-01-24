package com.alvesjefs.parkweb.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setSigningKey("MYSECRET123");
		return jwtAccessTokenConverter;
	}

	@Bean
	public JwtTokenStore jwtAccessToken() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}
}

package com.microservices.moviecatalogservice.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean(name = "restTemplate")
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}

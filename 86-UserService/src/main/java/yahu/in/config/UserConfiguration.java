package yahu.in.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserConfiguration {
	
	@Bean
	@LoadBalanced //it seems like cloud dependency needed
//Used so that restTemplate uses name instead of host and port in url
	public RestTemplate rt () {
		return new RestTemplate();
	}
	
}

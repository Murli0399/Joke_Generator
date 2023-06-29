package com.joke.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenAIConfig {

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate template = new RestTemplate();
		template.getInterceptors().add((request, body, execution) -> {
			request.getHeaders().add("Authorization",
					"Bearer " + "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");
			return execution.execute(request, body);
		});
		return template;
	}

}

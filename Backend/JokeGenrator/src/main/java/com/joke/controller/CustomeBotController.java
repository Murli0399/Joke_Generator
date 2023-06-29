package com.joke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.joke.dto.ChatGptRequest;
import com.joke.dto.ChatGptResponse;

@CrossOrigin("*")
@RestController
public class CustomeBotController {

//	@Value("${openai.model}")
//	private String model;

//	@Value('${openai.api.url}')
//	private String url;

	@Autowired
	private RestTemplate template;

	@GetMapping("/chat")
	public String chat(@RequestParam("prompt") String prompt) {
		String str = "tell me the joke on " + prompt + " in hindi language";
		ChatGptRequest req = new ChatGptRequest("gpt-3.5-turbo", str);
		ChatGptResponse response = template.postForObject("https://api.openai.com/v1/chat/completions", req,
				ChatGptResponse.class);
		return response.getChoices().get(0).getMessage().getContent();
	}

}

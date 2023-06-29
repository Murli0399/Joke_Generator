package com.joke.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptResponse {

	private List<Choice> choices;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Choice {
		private int index;
		private Message message;
	}

}

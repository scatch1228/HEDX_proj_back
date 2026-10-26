package com.ruby.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruby.tool.AiTool;


@RestController
@RequestMapping("/llm")
public class LlmController {

	private final ChatClient chatClient;
	private final AiTool aiTool;

	public LlmController(ChatClient.Builder builder, AiTool aiTool) {
		this.chatClient=builder.build();
		this.aiTool = aiTool;
	}
	
	@GetMapping("/generate")
	public String generateResponse(@RequestParam(value = "prompt", defaultValue = "Hello!") String prompt){
		String response = this.chatClient.prompt()
                .user(prompt)
                .tools(aiTool) // AI가 쓸 수 있도록 도구 등록
                .call()
                .content();

        return response;
	}
	
}

package com.chatservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatservice.dto.ChatDto;
import com.chatservice.service.ChatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

	private final ChatService chatService;

	@PostMapping("/addchat")
	public ResponseEntity<String> CreateTicket(@RequestBody ChatDto chatDto) {
		return chatService.CreateTicket(chatDto);
	}

	@GetMapping("/getchat")
	public List<ChatDto> getChat() {
		return chatService.getChat();
	}
}

package com.chatservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chatservice.dto.ChatDto;

@Service
public interface ChatService {

	public ResponseEntity<String> CreateTicket(ChatDto chatDto);

	public List<ChatDto> getChat();

}

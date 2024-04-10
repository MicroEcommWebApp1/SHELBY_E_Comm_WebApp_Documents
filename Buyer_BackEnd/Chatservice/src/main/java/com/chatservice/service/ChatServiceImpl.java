package com.chatservice.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import com.chatservice.dto.ChatDto;
import com.chatservice.entity.Chat;
import com.chatservice.repository.ChatRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService{
	
	private final ChatRepo chatRepo;
	private final ModelMapper modelMapper;

	@Override
	public ResponseEntity<String> CreateTicket(ChatDto chatDto) {
		Chat chat = this.modelMapper.map(chatDto, Chat.class);
		chatRepo.save(chat);
		return new ResponseEntity<>("{\"message\": \"Successfully Sent\"}", HttpStatus.OK);
	}

	@Override
	public List<ChatDto> getChat() {
		List<Chat> chat=chatRepo.findAll();
		return chat.stream().map(chats -> modelMapper.map(chats, ChatDto.class)).toList();
	}

}

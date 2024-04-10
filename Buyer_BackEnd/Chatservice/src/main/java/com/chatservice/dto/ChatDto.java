package com.chatservice.dto;

import lombok.Data;

@Data
public class ChatDto {
	
	private Long ticketID;
	private String email;
	private String name;
	private String description;

}

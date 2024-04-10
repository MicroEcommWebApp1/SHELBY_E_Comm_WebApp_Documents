package com.chatservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatservice.entity.Chat;

@Repository
public interface ChatRepo extends JpaRepository<Chat,Long>{

}

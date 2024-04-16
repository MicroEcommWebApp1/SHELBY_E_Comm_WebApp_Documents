import { Injectable } from '@angular/core';
import { ChatDto } from '../chat-dto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChatService {

  private baseUrl = 'http://localhost:9090/chat'; // Update the base URL with port 8087

  constructor(private http: HttpClient) { }

  createChat(chatDto: ChatDto): Observable<string> {
    return this.http.post<string>(`${this.baseUrl}/addchat`, chatDto);
  }

  getChats(): Observable<ChatDto[]> {
    return this.http.get<ChatDto[]>(`${this.baseUrl}/getchat`);
  }
}


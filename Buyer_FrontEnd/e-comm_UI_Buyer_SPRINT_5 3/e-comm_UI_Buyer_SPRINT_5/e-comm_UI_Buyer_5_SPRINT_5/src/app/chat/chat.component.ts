import { Component, OnInit } from '@angular/core';
import { ChatDto } from '../chat-dto';
import { ChatService } from '../services/chat.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  ticketId!: number;
  buyerDto: any; // Assuming it's an object containing email and name
  description!: string;

  constructor(private chatService: ChatService) { }

  ngOnInit(): void {
    this.buyerDto = JSON.parse(localStorage.getItem('buyerDto') || '{}');
    this.loadTicketId();
  }

  loadTicketId(): void {
    // Simulate ticket ID generation (you may replace this with actual logic)
    this.ticketId = Math.floor(Math.random() * 1000) + 1;
  }

  createChat(): void {
    const chatDto: ChatDto = {
      ticketID: this.ticketId,
      email: this.buyerDto.email,
      name: this.buyerDto.name,
      description: this.description
    };

    this.chatService.createChat(chatDto).subscribe(response => {
      console.log('Chat created successfully:', response);
      alert('Ticket Raised Successfully, issue will be resolved in 48 working hours. Please Check Emails');
      this.resetForm();
    }, error => {
      console.error('Error creating chat:', error);
   
    });
  }

  resetForm(): void {
    this.description = '';
  }
}

import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'e-comm';
  isLoggedIn: boolean = false; // You may need to implement your own logic for this
  // Implement your logout functionality here
  confirmLogout() {
}}

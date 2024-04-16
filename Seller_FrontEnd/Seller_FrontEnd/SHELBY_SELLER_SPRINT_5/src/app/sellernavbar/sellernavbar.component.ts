import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-sellernavbar',
  templateUrl: './sellernavbar.component.html',
  styleUrls: ['./sellernavbar.component.css']
})
export class SellernavbarComponent {
 
  constructor(private router: Router){}


   
  logout(): void {
    // Clear local storage upon logout
    localStorage.removeItem('token');
    localStorage.clear();
    // Redirect to login page or any other desired route
    this.router.navigate(['/login']);
  }
}

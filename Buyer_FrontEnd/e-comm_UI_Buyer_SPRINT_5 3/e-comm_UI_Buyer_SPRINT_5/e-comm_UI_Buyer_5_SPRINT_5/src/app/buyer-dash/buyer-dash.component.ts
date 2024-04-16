import { Component, OnInit } from '@angular/core';

import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
import { BuyerDto } from '../buyer-dto';
import { BuyerService } from '../buyer.service';

@Component({
  selector: 'app-buyer-dash',

  styleUrls: ['./buyer-dash.component.css'],
    templateUrl: './buyer-dash.component.html',
})
export class BuyerDashComponent implements OnInit {
 


profileData:any;
buyerDto: BuyerDto | null = null;
email!:string;
 
  // profileService: any;

 
  constructor(private router: Router,private buyerService: BuyerService,private userService: UserService) {}

  ngOnInit(): void {
    
    const buyerDtoString = localStorage.getItem('buyerDto');
    if (buyerDtoString) {
      this.buyerDto = JSON.parse(buyerDtoString);
    }
    }
   
   
    onEdit(): void {
      this.router.navigate(['/editprofile']);
    }

  logout(): void {
     
      // localStorage.removeItem('token');
      localStorage.clear();
      // Redirect to login page or any other desired route
      this.router.navigate(['/login']);
    }
  }
  
  


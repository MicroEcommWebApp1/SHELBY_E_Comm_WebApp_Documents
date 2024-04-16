import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { Router } from '@angular/router';
import { BuyerDto } from '../buyer-dto';
import { BuyerService } from '../buyer.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit  {
  buyerDto: BuyerDto | null = null;
  email!:string;
 
  constructor(private router: Router,private buyerService: BuyerService) { }
 
  ngOnInit(): void {
    // this.loadBuyerDetails(this.email);
    const buyerDtoString = localStorage.getItem('buyerDto');
    if (buyerDtoString) {
      this.buyerDto = JSON.parse(buyerDtoString);
    }
  }
 

  onEdit(): void {
    this.router.navigate(['/editprofile']);
  }
}

  
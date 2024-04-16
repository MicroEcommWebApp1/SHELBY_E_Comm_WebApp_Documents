import { Component } from '@angular/core';
import { Register } from '../model/register.model';
import { Router } from '@angular/router';
import { SellerService } from '../service/seller.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {

  

profileData:any;
registerDto: Register | null = null;
email!:string;
  
  // profileService: any;

 
  constructor(private router: Router,private sellerService: SellerService,private userService: UserService) {}

  ngOnInit(): void {
    
    const registerDtoString = localStorage.getItem('registerDto');
    if (registerDtoString) {
      this.registerDto = JSON.parse(registerDtoString);
    }
    }
}
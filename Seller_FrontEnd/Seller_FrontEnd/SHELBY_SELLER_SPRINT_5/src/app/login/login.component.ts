import { Component } from '@angular/core';
import { LoginService } from '../service/login.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import Swal from 'sweetalert2';
import { SellerService } from '../service/seller.service';
import { User } from '@auth0/auth0-spa-js';
import { login } from '../model/login.model';
import { Register } from '../model/register.model';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  
  user = {
  
    sellerEmailID: '',
  password:''}

    constructor( private loginService:LoginService , private router: Router,private sellerservice :SellerService,private authService :AuthService ){}

    login(loginForm: NgForm) {
      if (loginForm.invalid) {
        return; // If the form is invalid, do not proceed with registration
      }
     
      this.loginService.loginseller(this.user).subscribe({
        next: (data) => {
          this.sellerservice.getSellerDetailsByEmail(this.user.sellerEmailID).subscribe({
            next: (registerDto: Register[]) => {
              this.authService.login();
              if (registerDto.length > 0) {
                localStorage.setItem('registerDto', JSON.stringify(registerDto[0]));
                  Swal.fire({
                    title: "Good job!",
                    text: "Successfully Loggedin!",
                    icon: "success"
                  });
                  this.router.navigate(['/sellerdashboard']);
                // alert("Login successful");
                // this.router.navigate(['/buyerdash']);
              }
            },
            error: (e) => {
              console.log(e);
              if (e.status === 200) {
                Swal.fire({
                  title: "Good job!",
                  text: "Successfully Loggedin!",
                  icon: "success"
                });
                this.router.navigate(['/sellerdashboard']);
              } else {
                Swal.fire({
                  icon: "error",
                  title: "Oops...",
                  text: "Invalid Credentials"
                });
                console.log("logged fail");
              }
            }
          });
        },
        error: (errorResponse) => {
          Swal.fire({
            icon: "error",
            title: "Oops...",
            text: errorResponse.error.message || "An error occurred during login."
          });
        }
      });
    }
   

}

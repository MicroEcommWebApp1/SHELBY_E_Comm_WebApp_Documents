import { Component ,OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup,FormControl, Validators } from '@angular/forms';
import { LoginDto } from '../login-dto';

import Swal from 'sweetalert2';
import { LoginService } from '../service/login.service';
import { BuyerService } from '../buyer.service';
import { BuyerDto } from '../buyer-dto';
import { AuthService } from '../auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  loginDto: LoginDto = new LoginDto();
 
 
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private loginService: LoginService,
    private authService: AuthService,
   
    private buyerService: BuyerService
  ) { }
 
  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }
 
  // login() {
  //   console.log(this.loginForm.value);
  //   // this.authService.login();
  //   this.authService.login();
  //     // Navigate to the main page after successful login
  //     this.router.navigate(['/mainpage']);
  //   }
  
  
 
  loginUser() {
    this.loginDto = this.loginForm.value;
    this.loginService.loginUser(this.loginDto).subscribe({
      next: (data) => {
        this.buyerService.getBuyerDetailsByEmail(this.loginDto.email).subscribe({
          next: (buyerDto: BuyerDto[]) => {
            this.authService.login(); 
            if (buyerDto.length > 0) {
              localStorage.setItem('buyerDto', JSON.stringify(buyerDto[0]));
                Swal.fire({
                  title: "Good job!",
                  text: "Successfully Loggedin!",
                  icon: "success"
                });
                this.router.navigate(['/mainpage']);
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
              this.router.navigate(['/mainpage']);
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
  get email() {
    return this.loginForm.get('email');
  }
 
  get password() {
    return this.loginForm.get('password');
  }
}
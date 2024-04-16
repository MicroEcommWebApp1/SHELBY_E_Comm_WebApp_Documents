import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit{
  responseMessage: string = '';
  
 
  constructor(private http: HttpClient,private router:Router) { }
 
  ngOnInit() {
  }
 
  forgotPassword(email: string) {
    const apiUrl = `http://localhost:8080/buyer/forgotpassword/${email}`;
    this.http.get(apiUrl).subscribe(
      (response: any) => {
        this.responseMessage = response.message;
        setTimeout(() => {
          this.router.navigate(['/login']);
        }, 2000);
      },
      (error) => {
        console.error('Error:', error);
        this.responseMessage = 'An error occurred. Email not Registered.';
      }
      );
  }
}
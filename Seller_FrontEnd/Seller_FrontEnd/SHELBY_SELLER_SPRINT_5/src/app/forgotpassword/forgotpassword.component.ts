import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent {

  responseMessage: string = '';
 
  constructor(private http: HttpClient, private router: Router) {}
 
  ngOnInit() {}
 
  forgotPassword(emailID: string) {
    const apiUrl = `http://localhost:8083/seller-registrations/forgotpassword/${emailID}`;
    this.http.get(apiUrl, { responseType: 'text' }).subscribe(
      (response: any) => {
        // Handle success response
        this.responseMessage = response;
        // You can handle the navigation logic here if needed
        //alert("please Check your Email for password")
        Swal.fire({
          title: "Hey there!!",
          text: "Check your mail for Password",
          icon: "success"
        });
        this.router.navigate(['/login']);
      },
      (error: HttpErrorResponse) => {
        console.error('Error:', error);
        if (error.error instanceof ErrorEvent) {
          // Client-side error
          Swal.fire({
            title: "OOPs!",
            text: "Error on the Server Side",
            icon: "error"
          });
          //this.responseMessage = 'An error occurred on the client side.';
        } else {
          // Server-side error
          this.responseMessage = error.error;
        }
      }
    );
  }

}

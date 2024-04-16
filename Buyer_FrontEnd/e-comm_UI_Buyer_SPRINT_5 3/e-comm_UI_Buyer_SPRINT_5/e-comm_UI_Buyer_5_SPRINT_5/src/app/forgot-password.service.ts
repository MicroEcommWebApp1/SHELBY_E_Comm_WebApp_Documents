import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { AbstractControl } from '@angular/forms';
@Injectable({
  providedIn: 'root'
})
export class ForgotPasswordService {
  registerService(arg0: AbstractControl<any, any>, arg1: AbstractControl<any, any>) {
    throw new Error('Method not implemented.');
  }
  private baseURL = "http://localhost:9090/buyer/forgotpassword";
  
  constructor(private httpClient:HttpClient) { }
 
  getpasswordtoemail(email: string){
    return this.httpClient.get(`${this.baseURL}/${email}`);



}

  
}

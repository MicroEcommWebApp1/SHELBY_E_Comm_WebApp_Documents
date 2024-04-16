import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BuyerDto } from '../buyer-dto';
import { AbstractControl } from '@angular/forms';
 
@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  registerService(arg0: AbstractControl<any, any>, arg1: AbstractControl<any, any>) {
    throw new Error('Method not implemented.');
  }
 
  private baseURL = "http://localhost:9090/buyer/register";
  buyerRegistration: any;
  constructor(private httpClient:HttpClient) { }
 
  registerUser(buyerDto:BuyerDto){
    return this.httpClient.post(`${this.baseURL}`,buyerDto);
 
 
 
}}


 
 

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Register } from '../model/register.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EditprofileService {

  
  private baseURL = "http://localhost:9090/seller-registrations/updateprofile";
 
  constructor(private http: HttpClient) { }
 
  updateSeller(registerDto: Register): Observable<any> {
    return this.http.put<any>(`${this.baseURL}`, registerDto);
  }
}

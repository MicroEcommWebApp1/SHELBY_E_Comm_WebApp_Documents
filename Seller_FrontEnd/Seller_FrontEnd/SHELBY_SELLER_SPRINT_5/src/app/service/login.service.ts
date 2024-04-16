import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


const BASIC_URL=['http://localhost:9090']
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http : HttpClient) { }

  
  loginseller(seller : any):Observable<any>{
    return this.http.post(BASIC_URL+'/seller-registrations/login',seller);

  }
}


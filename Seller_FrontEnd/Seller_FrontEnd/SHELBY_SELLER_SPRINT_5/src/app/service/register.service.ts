import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Register } from '../model/register.model';

const BASIC_URL=['http://localhost:9090']

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http : HttpClient) { }

  registerseller(seller : any):Observable<any>{
    return this.http.post(BASIC_URL+'/seller-registrations/register',seller);

  }
}

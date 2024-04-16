import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BuyerDto } from './buyer-dto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BuyerService {

 
  private baseURL = "http://localhost:9090/buyer/buyerdetails";
  constructor(private http: HttpClient) { }
 
 
  getBuyerDetailsByEmail(email: string): Observable<BuyerDto[]> {
    return this.http.get<BuyerDto[]>(`${this.baseURL}/${email}`);
  }
}

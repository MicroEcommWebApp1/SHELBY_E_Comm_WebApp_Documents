import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Register } from '../model/register.model';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class SellerService {


  private BASIC_URL=['http://localhost:9090/seller-registrations/sellerdetails']

  constructor(private http:HttpClient) { }

  getSellerDetailsByEmail(emailID: string): Observable<Register[]> {
    return this.http.get<Register[]>(`${this.BASIC_URL}/${emailID}`);



  }
}

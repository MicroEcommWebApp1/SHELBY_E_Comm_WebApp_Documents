import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SellerOrderListDto } from '../model/seller-order-list-dto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SellerOrderListService {

  private baseUrl = 'http://localhost:9090'; // Modify the port number accordingly
  private endpoint = '/sellerorderdetails';

  constructor(private http: HttpClient) { }

  getOrderdetailsBySellerEmailID(sellerEmailID: string): Observable<SellerOrderListDto[]> {
    return this.http.get<SellerOrderListDto[]>(`${this.baseUrl}${this.endpoint}/${sellerEmailID}`);
  }
}

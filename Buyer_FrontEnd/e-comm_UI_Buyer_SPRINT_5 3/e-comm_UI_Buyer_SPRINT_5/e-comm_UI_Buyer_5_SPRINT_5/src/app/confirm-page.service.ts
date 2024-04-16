import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderListDto } from './order-list-dto';

@Injectable({
  providedIn: 'root'
})
export class ConfirmPageService {

  private baseUrl = 'http://localhost:9090/order'; 

  constructor(private http: HttpClient) { }

  addOrder(orderDto: OrderListDto): Observable<string> {
    return this.http.post<string>(`${this.baseUrl}/order`, orderDto);
  }
}

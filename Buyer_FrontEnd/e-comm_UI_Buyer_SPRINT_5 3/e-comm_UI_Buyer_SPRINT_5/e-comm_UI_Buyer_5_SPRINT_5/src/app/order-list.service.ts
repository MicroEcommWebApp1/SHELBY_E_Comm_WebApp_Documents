import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderListDto } from './order-list-dto';

@Injectable({
  providedIn: 'root'
})
export class OrderListService {

  private baseUrl = 'http://localhost:9090/order'; // Updated port number

  constructor(private http: HttpClient) { }

  addOrder(orderDto: OrderListDto): Observable<string> {
    return this.http.post<string>(`${this.baseUrl}/order`, orderDto);
  }

  getAllOrders(): Observable<OrderListDto[]> {
    return this.http.get<OrderListDto[]>(`${this.baseUrl}/orderdetails`);
  }

  getOrderdetailsByEmail(email: string): Observable<OrderListDto[]> {
    return this.http.get<OrderListDto[]>(`${this.baseUrl}/orderdetails/${email}`);
  }
}


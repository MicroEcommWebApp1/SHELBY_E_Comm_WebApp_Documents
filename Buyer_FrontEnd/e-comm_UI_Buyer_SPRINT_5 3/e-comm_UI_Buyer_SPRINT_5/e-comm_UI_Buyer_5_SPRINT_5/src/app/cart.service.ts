import { Injectable } from '@angular/core';
import { Product } from './product.model';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { CartDto } from './cart-dto';
 
@Injectable({
  providedIn: 'root'
})
// export class CartService {
 
//   cartItems: Product[] = [];
 
//   constructor() { }
 
//   addToCart(item: Product) {
//     this.cartItems.push(item);
//   }
 
//   removeFromCart(index: number) {
//     this.cartItems.splice(index, 1);
//   }
 
//   getTotalPrice(): number {
//     return this.cartItems.reduce((total, item) => total + item.price, 0);
//   }
// }
export class CartService {
  cartItems: Product[] = [];
 
  private baseUrl = 'http://localhost:9090/cart'; // Update with your backend URL
 
  constructor(private http: HttpClient) { }
 
  addtoCart(cartDto: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/cart`, cartDto)
      .pipe(
        catchError(this.handleError)
      );
  }
 
  getAllCartDetails(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/cartdetails`)
      .pipe(
        catchError(this.handleError)
      );
  }
 
  getCartDetailsByEmail(email: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/cartdetails/${email}`)
      .pipe(
        catchError(this.handleError)
      );
  }
 
  deleteShoppingCart(email: string, productId: number| null): Observable<any> {
  //   return this.http.delete<any>(`${this.baseUrl}/delcart/${email}/${productId}`)
  //     .pipe(
  //       catchError(this.handleError)
  //     );  
  // }
 
  if (productId !== null) {
    return this.http.delete<any>(`${this.baseUrl}/delcart/${email}/${productId}`)
      .pipe(
        catchError(this.handleError)
      );
  } else {
    return throwError('productId is null');
  }
}
 
  private handleError(error: any) {
    console.error('An error occurred:', error);
    return throwError(error);
 
   
  }
 
  updateShoppingCart(cartDto: CartDto, email: string, productId: number): Observable<any> {
    const url = `${this.baseUrl}/update/${email}/${productId}`;
    return this.http.patch<any>(url, cartDto);
  }
 
  getTotalPrice(): number {
    return this.cartItems.reduce((total, item) => total + (item.price * item.quantity), 0);
  }
}
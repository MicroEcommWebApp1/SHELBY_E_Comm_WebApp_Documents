import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, map, throwError } from 'rxjs';
import { Product } from '../model/product.model';

const BASIC_URL=['http://localhost:9090']

@Injectable({
  providedIn: 'root'
})
export class ProductService {
 

  constructor(private http : HttpClient) { }

  private baseUrl = 'http://localhost:9090/products/';
 
  public addProduct(product: FormData): Observable<any> {
    return this.http.post<Product>("http://localhost:9090/products/addNewProduct",product);
  }

  public getAllProducts(){
    return this.http.get<Product[]>("http://localhost:9090/products/getAllProducts");
  }

  getProductsByEmail(emailID: String) {
    return this.http.get<any>(`http://localhost:9090/products/productdetails/${emailID}`).pipe(
     catchError(this.handleError)
   );
  }

 

  private handleError(error: any) {
    console.error('An error occurred:', error);
    return throwError(error);

    
  }

  public deleteProduct(productId:number)
  {
    return this.http.delete("http://localhost:9090/products/deleteProduct/"+productId);
  }

  public getProductDetailsById(productId:any){
    return this.http.get<Product>("http://localhost:9090/products/getProductDetailsById/"+productId);
  }
}

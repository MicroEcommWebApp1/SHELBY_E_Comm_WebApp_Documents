import { Injectable } from '@angular/core';
import { Product } from '../model/product.model';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable, map, of, switchMap } from 'rxjs';
import { ProductService } from './product.service';
import { ImageProcessingService } from './image-processing.service';


@Injectable({
  providedIn: 'root'
})
export class ProductResolveService implements Resolve<Product>{

  constructor(private productservice:ProductService, private imageProcessingService:ImageProcessingService) { }
  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot):Observable<Product> {
    const id=route.paramMap.get("productId");
    if(id)
    {
      return this.productservice.getProductDetailsById(id)
      .pipe(
       map(p=>this.imageProcessingService.createImages(p))
      );
    }
    else{
      return of(this.getProductDetails());
    }
  }

  getProductDetails(){
    return {
     productId:null,
     id:0, 
     name: '',
      sellerEmailID:'',
    description: '',
    tags:'',
    price: 0,
    quantity: 0,
    category: '',
    subcategory1: '',
    subcategory2: '',
    thumbnail:'',
    productImages: []
    };
  }
}

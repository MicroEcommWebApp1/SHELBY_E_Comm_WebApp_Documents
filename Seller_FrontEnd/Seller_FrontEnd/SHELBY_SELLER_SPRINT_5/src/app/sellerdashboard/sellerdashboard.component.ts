import { Component } from '@angular/core';
import { ProductService } from '../service/product.service';

import { HttpErrorResponse } from '@angular/common/http';
import { Product } from '../model/product.model';
import { MatDialog } from '@angular/material/dialog';
import { ShowProductImagesComponent } from '../show-product-images/show-product-images.component';
import { ImageProcessingService } from '../service/image-processing.service';
import { map } from 'rxjs';

import { Router } from '@angular/router';
import { Register } from '../model/register.model';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-sellerdashboard',
  templateUrl: './sellerdashboard.component.html',
  styleUrls: ['./sellerdashboard.component.css']
})
export class SellerdashboardComponent {
  registerDto!: Register;
  productDetails : Product[]=[];
  displayedColumns: string[] = ['ID', 'NAME','THUMBNAIL','IMAGES', 'DESC', 'PRICE','QUANTITY','CATEGORY','SUBCATEGORY1','SUBCATEGORY2','EDIT','DELETE'];

  ngOnInit():void{
   
    this.registerDto = JSON.parse(localStorage.getItem('registerDto') || '{}');
    console.log(this.registerDto.sellerEmailID);
    this.registerDto.sellerEmailID=this.registerDto.sellerEmailID;
   this.getAllProducts();
  // this.fetchProducts();
  }


  constructor(private productservice:ProductService, 
    public imagediaolog:MatDialog ,
    private imageProcessingService:ImageProcessingService,
    private router:Router){}

    fetchProducts() {
      this.productservice.getProductsByEmail(this.registerDto.sellerEmailID).subscribe(
        (cartItems:Product[]) => {
          this.productDetails =cartItems;
          console.log(cartItems);
        },
        error => {
          console.error('Error fetching cart items:', error);
        }
      );
    }

  
  public getAllProducts(){
  
   // this.register.emailID = this.register.emailID;
    this.productservice.getProductsByEmail(this.registerDto.sellerEmailID)
    .pipe(
      map((products: Product[]) => {
        return products.map((product: Product) => {
          // Transform the product using both functions
          const productWithImages = this.imageProcessingService.createImages(product);
          //const productWithThumbnail = this.imageProcessingService.createImage(productWithImages);
          return productWithImages;
        });
      })
    )
    .subscribe(
      (response:Product[])=>
      {
        console.log(response);
        this.productDetails=response;
        
      },
      (error:HttpErrorResponse)=>{
        console.error('Error Displaying Products', error);
        if (error.status === 400) {
          console.error('Details are not entered!!');
          alert('Please make sure that you Enter all the Details');
        } 
        else{
          alert('Error Adding product: ' + error.message);
        }
      }
    );
  }
  
  deleteProduct(productId:number)
  {
    this.productservice.deleteProduct(productId).subscribe(
      (response)=>
      {
        console.log(response);
       Swal.fire({
        title: "Good job!",
        text: "PRODUCT DELETED!",
       icon: "success" 
       })
        this.getAllProducts();
      },
      (error)=>{
        console.log(error);
      }
    );
  }

  editProductDetails(productId:any){
    this.router.navigate(['/addproduct',{productId:productId}]);
  }

  SelectImages(product:Product){
    console.log(product);
    this.imagediaolog.open(ShowProductImagesComponent,{
      data:{
        image:product.productImages
      },
      height:'500px',width:'600px'});
  }
  
}

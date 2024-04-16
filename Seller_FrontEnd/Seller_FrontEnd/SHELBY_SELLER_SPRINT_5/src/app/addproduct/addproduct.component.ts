import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { ActivatedRoute, Router } from '@angular/router';
import {MatFormFieldModule} from '@angular/material/form-field';
import { Product } from '../model/product.model';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { FileHandle } from '../model/file-handke.model';
import { DomSanitizer } from '@angular/platform-browser';
import Swal from 'sweetalert2';
import { Register } from '../model/register.model';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit{

  registerDto!: Register;
  isNewProduct=true;
  product: Product={
    productId: null,
    name: '',
    description: '',
    price: 0,
    quantity: 0,
    category: '',
    subcategory1: '',
    subcategory2: '',
    thumbnail: '',
    productImages: [],
    sellerEmailID: '',
    id: 0,
    tags: ''
  }

  constructor( private productservice:ProductService , 
    private router: Router ,
    private sanitizer:DomSanitizer,
    private activatedroute:ActivatedRoute){}

  ngOnInit(): void {
    this.product=this.activatedroute.snapshot.data['product'];
   
    if(this.product && this.product.productId){
      this.isNewProduct=false;
    }

    this.registerDto = JSON.parse(localStorage.getItem('registerDto') || '{}');
    this.product.sellerEmailID=this.registerDto.sellerEmailID;
    this.product.id=this.registerDto.id;
    console.log(this.product.sellerEmailID);
  
  }


  addProduct(productForm: NgForm){
    
    const productFormData= this.prepareFormData(this.product);
    
    this.productservice.addProduct(productFormData).subscribe(
     (response:Product)=>{
      console.log(response);
      Swal.fire({
        title: "Good job!",
        text: "Product Added Successfully!",
        icon: "success"
      });
      //alert('product added');
      this.router.navigate(['/sellerdashboard']);
      },
      (error:HttpErrorResponse)=>
      {
        console.log(error);
      }
    );
  }
   
  prepareFormData(product :Product):FormData{
    const formData =new FormData();
    
    formData.append(
      'product',
       new Blob([JSON.stringify(product)],{type:'application/json'})
    );

    for(var i=0;i<product.productImages.length;i++)
    {
      formData.append(
        'imageFile',
        product.productImages[i].file,
        product.productImages[i].file.name
      );
    }
    
  
    return formData;



  }
  
    onFileSelected(event: any) {
      if(event.target.files)
      {
        const file=event.target.files[0];
         
        const fileHandle:FileHandle={
          file : file,
          url:this.sanitizer.bypassSecurityTrustUrl(
            window.URL.createObjectURL(file)
          )
        }

        this.product.productImages.push(fileHandle);
      }
    }

    removeImages(i:number)
    {
      this.product.productImages.slice(i,1);
    }
}

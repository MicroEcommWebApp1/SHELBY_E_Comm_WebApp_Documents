import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../product.service';
import { ImageProcessingService } from '../services/imageprocessing.service';
import { Product } from '../product.model';
import { CartService } from '../cart.service';
import { BuyerDto } from '../buyer-dto';

@Component({
  selector: 'app-product-detail2',
  templateUrl: './product-detail2.component.html',
  styleUrls: ['./product-detail2.component.css']
})

export class ProductDetail2Component implements OnInit {

  product!:Product;
  buyerDto: BuyerDto = new BuyerDto();


  constructor(
    private service:ProductService, 
    private active:ActivatedRoute,
     private imageProcessingService:ImageProcessingService,
     private CartService: CartService){}
  
  ngOnInit(): void {
    this.buyerDto = JSON.parse(localStorage.getItem('buyerDto') || '{}');
    let productid=this.active.snapshot.paramMap.get('productId');
    //console.log("product id is",productid);
    productid && this.service.getProductById(productid).subscribe(
      (res)=>{
        this.product = this.imageProcessingService.createImages(res);
      console.log(res);
      },
      (error)=>
      {
        console.log(error);
      }

    )
  }

  addToCart(item: Product) {
    const cartItem = {
      productId: item.productId,
      seller_id: item.id,
      name: item.name,
      sellerEmailID: item.sellerEmailID,
      email: this.buyerDto.email,
      description: item.description,
      thumbnail: item.thumbnail,
      price: item.price,
      quantity: 1,
      category: item.category,
      subcategory1: item.subcategory1,
      subcategory2: item.subcategory2
    };

    this.CartService.addtoCart(cartItem).subscribe(
      response => {
        console.log('Product added to cart:', response);
        // Optionally, you can handle success here, such as showing a success message
      },
      error => {
        console.error('Error adding product to cart:', error);
        // Handle error here, such as showing an error message
      }
    );
    document.querySelectorAll('.button').forEach(button => button.addEventListener('click', e => {
      e.preventDefault();
     
      if(!button.classList.contains('loading')) {
   
          button.classList.add('loading');
   
          setTimeout(() => button.classList.remove('loading'), 1700);
   
      }
     
  }));
  
  }

}
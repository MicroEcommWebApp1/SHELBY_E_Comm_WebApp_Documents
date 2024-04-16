import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/product.model';
import { ProductService } from 'src/app/product.service';
import { CartService } from 'src/app/cart.service';
import { BuyerDto } from 'src/app/buyer-dto';

@Component({
  selector: 'app-saree',
  templateUrl: './saree.component.html',
  styleUrls: ['./saree.component.css']
})
export class SareeComponent implements OnInit{
  buyerDto: BuyerDto = new BuyerDto();

  
 ngOnInit():void{
  this.displayProducts();
  this.buyerDto = JSON.parse(localStorage.getItem('buyerDto') || '{}');
 }
 
  constructor(private productService:ProductService,private CartService: CartService){ }
  data!:Product[];

  displayProducts(){
    this.productService.getAllSaree().subscribe(res=>{
      this.data=res;
      console.log(res);
    },
    (error)=>{
      console.log(error);
    }
    );
  }
  addToCart(item: Product) {
    const cartItem = {
      productId: item.productId,
      name: item.name,
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

import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { map } from 'rxjs';
import { Product } from 'src/app/product.model';
import { ProductService } from 'src/app/product.service';
import { ImageProcessingService } from 'src/app/services/imageprocessing.service';
import { CartService } from 'src/app/cart.service';
import { BuyerDto } from 'src/app/buyer-dto';

@Component({
  selector: 'app-gadgets',
  templateUrl: './gadgets.component.html',
  styleUrls: ['./gadgets.component.css']
})
export class GadgetsComponent {
  buyerDto: BuyerDto = new BuyerDto();

  
  ngOnInit():void{
    this.displayProducts();
    this.buyerDto = JSON.parse(localStorage.getItem('buyerDto') || '{}');
   }
   
    constructor(private productService:ProductService, private imageProcessingService:ImageProcessingService,private CartService: CartService){ }
    data!:Product[];
  
    displayProducts(){
      this.productService.getAllGadgets()
      .pipe(
        map((products: Product[]) => {
          return products.map((product: Product) => {
            // Transform the product using both functions
            const productWithImages = this.imageProcessingService.createImages(product);
           // const productWithThumbnail = this.imageProcessingService.createImage(productWithImages);
            return productWithImages;
          });
        })
      )
      .subscribe(
        (response:Product[])=>
        {
          console.log(response);
          this.data=response;
          
        },
        (error:HttpErrorResponse)=>{
          console.error('Error Displaying Product', error);
          if (error.status === 400) {
            console.error('Details are not entered!!');
            alert('Please make sure that you Enter all the Details');
          } 
          else{
            alert('Error Adding product: ' + error.message);
          }
        }
      );}

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

import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../product.model';
import { CartService } from '../cart.service';
import { BuyerDto } from '../buyer-dto';
import { ImageProcessingService } from '../services/imageprocessing.service';


@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  // productId!: number;
  selectedSize: string = '';
  product!:Product;
  buyerDto: BuyerDto = new BuyerDto();
  products: Product[] = [];
  
  data!: Product[];
  
  // productdata:any |Product;

  constructor( private Productsservice: ProductService,private active:ActivatedRoute,private CartService: CartService,private imageprocessingservice:ImageProcessingService){}

  ngOnInit(): void {
    this.buyerDto = JSON.parse(localStorage.getItem('buyerDto') || '{}');
    let productid=this.active.snapshot.paramMap.get('productId');
    console.log("product id is",productid);
    if (productid) {
     this.Productsservice.getProductById(productid).subscribe(
      (res: Product) => {
       
        this.product = this.imageprocessingservice.createImages(res);
        console.log('Product details:', this.product);
      },
      error => {
        console.error('Error fetching product details:', error);
      }
    );
    }
  }

  getProductDetails() {
    
      
  }

addToCart(item: Product) {
  const cartItem = {
    productId: item.productId,
    
    seller_id: item.id,
    sellerEmailID: item.sellerEmailID,
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
setSize(size: string) {
  this.selectedSize = size;
}
}

// ngOnDestroy() {
//   if (this.productSubscription) {
//     this.productSubscription.unsubscribe(); // Unsubscribe to prevent memory leaks
//   }
// }


import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product.model';
import { map } from 'rxjs';
import { CartService } from '../cart.service';
import { ImageProcessingService } from '../services/imageprocessing.service';
import { HttpErrorResponse } from '@angular/common/http';
import { BuyerDto } from '../buyer-dto';

 
@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})

export class ShopComponent implements OnInit{
// product!: Product;
buyerDto: BuyerDto = new BuyerDto();
products: Product[] = [];
  data!: Product[];
  filteredProducts: Product[] = []; // Array to hold filtered products
  searchTerm: string = '';
  // searchTerm: string;
  // searchResults: any[];
 
 ngOnInit():void{
  this.displayProducts();
  this.buyerDto = JSON.parse(localStorage.getItem('buyerDto') || '{}');
  this.getProducts(); 
}
  constructor(private productService:ProductService, private imageProcessingService:ImageProcessingService, private CartService: CartService){ }
 
  loadProducts(): void {
    this.productService.getAllProducts().subscribe(
      (products: Product[]) => {
        this.products = products;
      },
      error => {
        console.error('Error loading products:', error);
      }
    );
  }
  getProducts(): void {
    this.productService.getAllProducts().subscribe(
      (products: Product[]) => {
        this.products = products;
        this.filteredProducts = [...this.products]; // Copy all products initially
        this.filterProducts(); // Filter initially in case there's already a search term
      },
      error => {
        console.error('Error loading products:', error);
      }
    );
  }
  
  displayProducts(){
    this.productService.getAllProducts()
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
    );
    // this.filteredProducts = this.products;
    // this.filteredProducts = this.products = this.data || [];
  }
   
  filterProducts(): void {
    if (!this.searchTerm.trim()) {
      if (!this.searchTerm.trim()) {
        this.filteredProducts = [...this.products]; // Reset to all products if search term is empty
        return;
      }
   
      const searchTermLower = this.searchTerm.trim().toLowerCase();
    const searchWords = searchTermLower.split(' ');
   
    this.filteredProducts = this.products.filter((product: any) => {
      const categoryLower = product.category.toLowerCase();
      const subcategory1Lower = product.subcategory1 && product.subcategory1.toLowerCase();
      const subcategory2Lower = product.subcategory2 && product.subcategory2.toLowerCase();
      const tagsLower = product.tags && product.tags.toLowerCase();
      const tagsArray = tagsLower.split(',');
 
      // Check if any of the search words exactly match any product term or tag
      const matchesSearchTerm = searchWords.some(word =>
        categoryLower === word ||
        subcategory1Lower === word ||
        subcategory2Lower === word ||
        tagsArray.includes(word) ||
        (word === 'women' && subcategory1Lower === word) ||
        (tagsArray.includes('men') && word === 'men') ||
        (categoryLower === 'apparel' && subcategory1Lower === 'men' && word === 'men')
      );
 
      return matchesSearchTerm;
    });
  }
    
  
    const searchTermLower = this.searchTerm.trim().toLowerCase();
    this.filteredProducts = this.products.filter(product => {
      const productNameLower = product.name.toLowerCase();
      const categoryLower = product.category.toLowerCase();
      const subcategory1Lower = product.subcategory1 && product.subcategory1.toLowerCase();
      const subcategory2Lower = product.subcategory2.toLowerCase();
      
      return productNameLower === searchTermLower ||
             categoryLower === searchTermLower ||
             subcategory1Lower === searchTermLower ||
             subcategory2Lower === searchTermLower ||
             (searchTermLower === 'women' && subcategory1Lower === searchTermLower) ||
             (categoryLower === 'apparel' && subcategory1Lower === 'men' && searchTermLower === 'men');
    });
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
      
    
    }
    }
    

  



     
    

import { Component,ViewChild, ElementRef, Renderer2,OnInit } from '@angular/core';

import { ProductService } from '../product.service';
import { BuyerDto } from '../buyer-dto';


interface Product {
[x: string]: any;

  id: number;
  name: string;
  price: number;
  image: string;
  category: string; // Add category property
  subcategory: string; 
}
@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css'],
  
})


export class MainpageComponent  implements OnInit {
  buyerDto: BuyerDto = new BuyerDto();
  @ViewChild('filtersSidebar') filtersSidebar!: ElementRef;
  @ViewChild('applyButton') applyButton!: ElementRef;

  products = [
    {id:1, name: 'Levis shirt', price: 900, image: 'https://th.bing.com/th/id/OIP.nQz-WhYEU1aS1CyyJdzyugHaJ4?rs=1&pid=ImgDetMain',category: 'Men', subcategory: 'shirt'  },
    {id:2, name: 'pepe Jeans', price: 1800, image: 'assets/jean.image.jpg',category: 'Men', subcategory: 'Jeans'  },
    {id:3, name: 'w Kurti', price: 700, image: 'assets/kurthi1.avif' ,category: 'Women', subcategory: 'Kurtis'},
    {id:4, name: 'Masaba Saree', price: 1300, image: 'assets/saree.webp' ,category: 'Women', subcategory: 'saree'},
    {id:5,name: 'Iphone promax', price: 110000, image: 'assets/iphine.jpg' ,category: 'Electronics', subcategory: 'mobile'},
    {id:6,name: 'Noise airdopes ', price: 71300, image: 'assets/noise-airdopes.webp' ,category: 'Electronics', subcategory: 'Earphones'}
  ];
  filteredProducts: any[] = [];
  categories: string[] = ['Men', 'Women', 'Electronics']; // Example categories
  subcategories: string[] = ['jeans', 'shirt', 'kurtis','saree','mobile','Laptop']; // Example subcategories
  selectedCategory: string = '';
  selectedSubcategory: string = '';
  filtersApplied: boolean = false;


  ngOnInit() {
    // Initially, show all products
    // this.displayProducts();
    this.filteredProducts = this.products;
    this.buyerDto = JSON.parse(localStorage.getItem('buyerDto') || '{}');
  }
  

constructor(private renderer: Renderer2,private productService:ProductService) {}
data!:Product[];


 
  
  // displayProducts(){
  //   this.productService.getAllProducts().subscribe(res=>{
  //     this.data=res;
  //     console.log(res);
  //   },
  //   (error)=>{
  //     console.log(error);
  //   }
  //   );
  // }
  
 
  filterProducts() {
    if (this.filtersApplied) 
      this.filteredProducts = this.products.filter(product => {
        const selectedCategoryLower = this.selectedCategory.toLowerCase();
        const productCategoryLower = product.category.toLowerCase();
        const selectedSubcategoryLower = this.selectedSubcategory.toLowerCase();
        const productSubcategoryLower = product.subcategory.toLowerCase();
  
        if (selectedCategoryLower && selectedCategoryLower !== '' && productCategoryLower !== selectedCategoryLower) {
          return false;
        }
        if (selectedSubcategoryLower && selectedSubcategoryLower !== '' && productSubcategoryLower !== selectedSubcategoryLower) {
          return false;
        }
        return true;
      });
    }

  applyFilters() {
    this.filtersApplied = true;
    this.filterProducts();
  }
  
  

  }




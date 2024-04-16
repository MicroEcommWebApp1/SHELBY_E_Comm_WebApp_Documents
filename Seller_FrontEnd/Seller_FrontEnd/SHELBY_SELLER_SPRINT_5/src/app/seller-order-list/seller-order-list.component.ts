import { Component, OnInit } from '@angular/core';
import { SellerOrderListDto } from '../model/seller-order-list-dto';
import { SellerOrderListService } from '../service/seller-order-list.service';

@Component({
  selector: 'app-seller-order-list',
  templateUrl: './seller-order-list.component.html',
  styleUrls: ['./seller-order-list.component.css']
})
export class SellerOrderListComponent implements OnInit {
  sellerOrderList: SellerOrderListDto[] = [];
  sellerEmailID: string = '';

  constructor(private sellerOrderService: SellerOrderListService) { }

  ngOnInit(): void {
    this.loadSellerEmailFromLocalStorage();
    this.loadSellerOrders();
  }

  loadSellerEmailFromLocalStorage(): void {
    const registerDto = JSON.parse(localStorage.getItem('registerDto') || '{}');
    this.sellerEmailID = registerDto.email || ''; // Set a default value if email is not found
  }

  loadSellerOrders(): void {
    if (this.sellerEmailID) { // Proceed only if sellerEmailID is not empty
      this.sellerOrderService.getOrderdetailsBySellerEmailID(this.sellerEmailID)
        .subscribe(
          data => {
            this.sellerOrderList = data;
          },
          error => {
            console.error('Error fetching seller orders:', error);
            // Handle error appropriately, e.g., show error message to the user
          }
        );
    } else {
      console.error('Seller email ID not found in local storage');
      // Handle scenario where seller email ID is not found in local storage
    }
  }
}
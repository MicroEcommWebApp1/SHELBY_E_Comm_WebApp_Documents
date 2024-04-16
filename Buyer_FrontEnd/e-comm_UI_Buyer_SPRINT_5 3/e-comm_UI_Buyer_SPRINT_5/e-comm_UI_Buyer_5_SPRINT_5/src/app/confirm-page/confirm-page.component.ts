import { Component, ElementRef, ViewChild } from '@angular/core';
import { PaymentDto } from '../payment-dto';
import { CartDto } from '../cart-dto';
import { PaymentService } from '../payment.service';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';
import { ConfirmPageService } from '../confirm-page.service';
import { OrderListDto } from '../order-list-dto';


@Component({
  selector: 'app-confirm-page',
  templateUrl: './confirm-page.component.html',
  styleUrls: ['./confirm-page.component.css']
})
export class ConfirmPageComponent {
  @ViewChild('confirmButton') confirmButton!: ElementRef;
  lastPayment!: PaymentDto;
  carts: CartDto[] = [];
  

  constructor( private router: Router,private paymentService: PaymentService, private cartService: CartService, private confirmpageService: ConfirmPageService) {}

  ngOnInit(): void {
    this.loadPaymentsAndCarts();

    setTimeout(() => {
      if (this.confirmButton) {
        this.confirmButton.nativeElement.click();
      }
    }, 1000);
    
  }

  loadPaymentsAndCarts(): void {
    const buyerDtoString = localStorage.getItem('buyerDto');
    if (buyerDtoString) {
      const buyerDto = JSON.parse(buyerDtoString);
      const email = buyerDto.email;
  
      this.paymentService.getPaymentsByEmail(email).subscribe(payments => {
        // Extract the last payment from the payments array
        this.lastPayment = payments[payments.length - 1];
        // localStorage.setItem('lastPayment', JSON.stringify(this.lastPayment));
      });
  
      this.cartService.getCartDetailsByEmail(email).subscribe(carts => {
        this.carts = carts;
        // localStorage.setItem('carts', JSON.stringify(this.carts));
      });
    } else {
      console.error('buyerDto not found in local storage');
      // Handle the case where buyerDto is not found in local storage
      // For example, you could redirect the user to a page where they can input their buyer information again
    }
  }
  confirmAllOrders(): void {
    if (this.lastPayment && this.carts.length > 0) {
      // Loop through each cart and confirm order
      this.carts.forEach((cart, index) => {
        const orderDto: OrderListDto = {
          
          buyerName: this.lastPayment.name,
          email: this.lastPayment.email,
          address: this.lastPayment.address,
          phoneNo: this.lastPayment.phoneNo,
          productName: cart.name,
          description: cart.description,
          thumbnail: cart.thumbnail,
          price: cart.price,
          quantity: cart.quantity,
          category: cart.category,
          subcategory1: cart.subcategory1,
          subcategory2: cart.subcategory2,
          totalAmount: this.lastPayment.totalCartValue,
          status: 'Payment Success',
          orderId: 0,
          productId: cart.productId,
          seller_id: cart.seller_id,
          sellerEmailID: cart.sellerEmailID,
          paymentId: this.lastPayment.paymentId,
          totalproductPrice: cart.totalproductPrice,
         
        
        };

        // Call the addOrder method of ConfirmpageService to send the order to the backend
        this.confirmpageService.addOrder(orderDto).subscribe(response => {
          console.log('Order placed successfully:', response);
          // Navigate only after the order has been successfully posted
          if (index === this.carts.length - 1) {
            this.router.navigate(['/orderList']);
          }
        }, error => {
          console.error('Error placing order:', error);
        });
      });
    } else {
      console.error('No payment data or carts available.');
    }
  }


}

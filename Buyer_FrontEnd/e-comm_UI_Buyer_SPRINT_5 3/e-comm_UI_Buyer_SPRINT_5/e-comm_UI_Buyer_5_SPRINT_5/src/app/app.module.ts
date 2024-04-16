import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule,Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AboutComponent } from './about/about.component';
import { RegisterComponent } from './register/register.component';
import { MainpageComponent } from './mainpage/mainpage.component';
import { BuyerDashComponent } from './buyer-dash/buyer-dash.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { EditprofileComponent } from './editprofile/editprofile.component';
import { BuyernavbarComponent } from './buyernavbar/buyernavbar.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ShopComponent } from './shop/shop.component';
import { ProductDetailComponent } from './product-detail copy/product-detail.component';
import { CartComponent } from './cart/cart.component';
import { ApparelComponent } from './components/apparel/apparel.component';
import { GadgetsHeaderComponent } from './components/gadgets-header/gadgets-header.component';
import { ApparelHeaderComponent } from './components/apparel-header/apparel-header.component';
import { GadgetsComponent } from './components/gadgets/gadgets.component';
import { JeanComponent } from './components/jean/jean.component';
import { ShirtComponent } from './components/shirt/shirt.component';
import { KurthiComponent } from './components/kurthi/kurthi.component';
import { ApplephoneComponent } from './components/applephone/applephone.component';
import { SamsungComponent } from './components/samsung/samsung.component';
import { BoatComponent } from './components/boat/boat.component';
import { NoiseComponent } from './components/noise/noise.component';
import { SareeComponent } from './components/saree/saree.component';

import { ProductDetail2Component } from './product-detail2/product-detail2.component';
import { ConfirmPageComponent } from './confirm-page/confirm-page.component';
import { OrderListComponent } from './order-list/order-list.component';
import { ChatComponent } from './chat/chat.component';



const routes: Routes = [
  { path: '', component: MainpageComponent },
  { path: 'product/:id', component: ProductDetailComponent }, 
  { path: '**', redirectTo: '' } ];

  
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    AboutComponent,
         RegisterComponent,
         MainpageComponent,
         BuyerDashComponent,
         ProductDetailComponent,
         ForgotPasswordComponent,
         CheckoutComponent,
         FooterComponent,
      ApparelComponent,
      GadgetsComponent,
      GadgetsHeaderComponent,
      ApparelHeaderComponent,
         EditprofileComponent,
         BuyernavbarComponent ,
         NavbarComponent,
         ShopComponent,
         CartComponent,
         JeanComponent,
       ShirtComponent,
       KurthiComponent,
       ApplephoneComponent,
       SamsungComponent,
       BoatComponent,
       NoiseComponent,
       SareeComponent,
     
       ProductDetail2Component,
       ConfirmPageComponent,
       OrderListComponent,
       ChatComponent,

  ],
  
 
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      { path: '', component: MainpageComponent },

      
    ]),
  ],

  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }

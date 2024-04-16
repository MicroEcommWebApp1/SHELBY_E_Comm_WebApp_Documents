import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { FooterComponent } from './footer/footer.component';


import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

import { Body2Component } from './body2/body2.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';

import{HttpClientModule} from "@angular/common/http";
import{ReactiveFormsModule,FormsModule} from '@angular/forms';
import { SellerdashboardComponent } from './sellerdashboard/sellerdashboard.component';

import { AddproductComponent } from './addproduct/addproduct.component';
import { ProfileComponent } from './profile/profile.component';

import { MatFormFieldModule } from '@angular/material/form-field';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatTableModule} from '@angular/material/table';
import {MatIconModule} from '@angular/material/icon';
import {MatDialogModule} from '@angular/material/dialog';
import { ShowProductImagesComponent } from './show-product-images/show-product-images.component';
import { SellernavbarComponent } from './sellernavbar/sellernavbar.component';

import { EditprofileComponent } from './editprofile/editprofile.component';
import {MatTabsModule} from '@angular/material/tabs';
import { SellerOrderListComponent } from './seller-order-list/seller-order-list.component';





@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    FooterComponent,

    LoginComponent,
    RegisterComponent,
  
    Body2Component,
    ForgotpasswordComponent,
    SellerdashboardComponent,
    
    AddproductComponent,
    ProfileComponent,
    ShowProductImagesComponent,
    SellernavbarComponent,
 
    EditprofileComponent,
    SellerOrderListComponent,

   
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,FormsModule,MatFormFieldModule,MatGridListModule,MatTableModule,MatDialogModule,
    MatIconModule,MatTabsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

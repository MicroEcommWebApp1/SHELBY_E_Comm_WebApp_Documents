import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { Body2Component } from './body2/body2.component';
import { RegisterComponent } from './register/register.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { SellerdashboardComponent } from './sellerdashboard/sellerdashboard.component';
import { ProfileComponent } from './profile/profile.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { ProductResolveService } from './service/product-resolve.service';
import { SellerOrderListComponent } from './seller-order-list/seller-order-list.component';

import { EditprofileComponent } from './editprofile/editprofile.component';

import { AuthGuard } from './service/auth.guard';





const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: '',
    component: Body2Component,
  },

  {
    path: 'addproduct',
    component: AddproductComponent,
    resolve: { product: ProductResolveService },
    canActivate:[AuthGuard],

  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'profile',
    component: ProfileComponent,canActivate:[AuthGuard]

  },
  { path: 'editprofile', component: EditprofileComponent ,canActivate:[AuthGuard]},
 
  {
    path: 'forgotpassword', component: ForgotpasswordComponent
  },
  {
    path: 'sellerdashboard',
    component: SellerdashboardComponent,canActivate:[AuthGuard]

  },

{
  path: 'sellerorderlist',
    component: SellerOrderListComponent, canActivate:[AuthGuard]

}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

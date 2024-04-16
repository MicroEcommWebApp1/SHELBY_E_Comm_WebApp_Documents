import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AboutComponent } from './about/about.component';
import { RegisterComponent } from './register/register.component';
import { MainpageComponent } from './mainpage/mainpage.component';
import { HomeComponent } from './home/home.component';

import { BuyerDashComponent } from './buyer-dash/buyer-dash.component';
import { ProductDetailComponent } from './product-detail copy/product-detail.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { EditprofileComponent } from './editprofile/editprofile.component';
import { ShopComponent } from './shop/shop.component';
import { CartComponent } from './cart/cart.component';
import { ApparelComponent } from './components/apparel/apparel.component';
import { GadgetsComponent } from './components/gadgets/gadgets.component';
import { SamsungComponent } from './components/samsung/samsung.component';
import { NoiseComponent } from './components/noise/noise.component';
import { ApplephoneComponent } from './components/applephone/applephone.component';
import { BoatComponent } from './components/boat/boat.component';
import { JeanComponent } from './components/jean/jean.component';
import { KurthiComponent } from './components/kurthi/kurthi.component';
import { SareeComponent } from './components/saree/saree.component';
import { ShirtComponent } from './components/shirt/shirt.component';
import { AuthGuard } from './auth.guard';
import { OrderListComponent } from './order-list/order-list.component';
import { ProductDetail2Component } from './product-detail2/product-detail2.component';
import { ConfirmPageComponent } from './confirm-page/confirm-page.component';
import { ChatComponent } from './chat/chat.component';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'  },
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'mainpage', component: MainpageComponent ,canActivate: [AuthGuard]},
  {path:'cart',component:CartComponent ,canActivate: [AuthGuard]},
  { path: 'buyer-dash', component: BuyerDashComponent , canActivate: [AuthGuard]},
  
  { path: 'forgot-password', component: ForgotPasswordComponent },
  {path:'checkout',component:CheckoutComponent ,canActivate: [AuthGuard]},
  {path:'editprofile',component:EditprofileComponent ,canActivate: [AuthGuard]},
  {path:'shop',component:ShopComponent ,canActivate: [AuthGuard]},
  {
    path:'saree',component:SareeComponent ,canActivate: [AuthGuard] },
  {
    path:'kurthi',
    component:KurthiComponent,canActivate: [AuthGuard]
  },
  {
    path:'jean',
    component:JeanComponent,canActivate: [AuthGuard]
  },
  {
    path:'shirt',
    component:ShirtComponent,canActivate: [AuthGuard]
  },
  {
    path:'boat',
    component:BoatComponent,canActivate: [AuthGuard]
  },
  {
    path:'applephone',
    component:ApplephoneComponent,canActivate: [AuthGuard]
  },
  {
    path:'noise',
    component:NoiseComponent,canActivate: [AuthGuard]
  },
  {
    path:'samsung',
    component:SamsungComponent,canActivate: [AuthGuard]
  },
  { path: 'productdetail/:productId',component:ProductDetailComponent , canActivate: [AuthGuard]},
  
  { path: 'productdetail2/:productId', component: ProductDetail2Component },

  {
    path:'about',
    component:AboutComponent,canActivate: [AuthGuard]
  },
  {path:'apparel',component:ApparelComponent,canActivate: [AuthGuard]},
  {path:'gadgets',component:GadgetsComponent,canActivate: [AuthGuard]},
  {path: 'confirmpage', component:ConfirmPageComponent, canActivate: [AuthGuard] },
  {path: 'orderList', component: OrderListComponent, canActivate: [AuthGuard]},
  {path: 'chat', component: ChatComponent, canActivate: [AuthGuard]},
  { path: '**', redirectTo: '/home' }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

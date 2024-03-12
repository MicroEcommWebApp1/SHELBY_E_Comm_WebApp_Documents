import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { Body2Component } from './body2/body2.component';
import { RegisterComponent } from './register/register.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';


const routes: Routes = [{
  path: 'login',
  component: LoginComponent,
},
{
  path:'',
  component : Body2Component,
},
{
  path:'register',
  component : RegisterComponent
},
{
  path:'forgotpassword',
  component : ForgotpasswordComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

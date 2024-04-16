import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isLoggedIn: boolean = false;
  // isAuthenticatedUser: any;
 
  constructor() { }
 
  login() {
   
    this.isLoggedIn = true;
  }
 
  logout() {
    
    this.isLoggedIn = false;
  }

  isAuthenticatedUser(): Observable<boolean> {
   
    return of(this.isLoggedIn);
  }

}

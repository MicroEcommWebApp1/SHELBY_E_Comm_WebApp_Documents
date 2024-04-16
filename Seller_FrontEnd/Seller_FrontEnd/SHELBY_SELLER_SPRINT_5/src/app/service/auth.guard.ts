import { Injectable } from '@angular/core';
import { CanActivate, Router, UrlTree } from '@angular/router';
import { AuthService } from './auth.service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import Swal from 'sweetalert2';
 
@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
 
  constructor(private authService: AuthService, private router: Router) {}
 
 
  canActivate(): Observable<boolean | UrlTree> {
    return this.authService.isAuthenticatedUser().pipe(
      map(authenticated => {
 
        if (authenticated) {
          // User is authenticated, allow navigation
          return true;
        }
         else {
          // alert('You must log in to access this page.');
          Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "You must log in to access this page."
          });
          return this.router.createUrlTree(['/login']);
         
        }
      })
    );
  }
}
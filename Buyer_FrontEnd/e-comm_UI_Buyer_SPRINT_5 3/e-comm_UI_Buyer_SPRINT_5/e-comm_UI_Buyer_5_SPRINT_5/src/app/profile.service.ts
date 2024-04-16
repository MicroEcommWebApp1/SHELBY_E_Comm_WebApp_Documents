import { EventEmitter, Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  // private userProfileSubject: BehaviorSubject<any> = new BehaviorSubject<any>(null);
  // public userProfile$: Observable<any> = this.userProfileSubject.asObservable();
  // profileUpdated: EventEmitter<any> = new EventEmitter<any>();

  constructor() {
    // Initialize user profile data (you can replace this with actual user data)
  //   const initialUserProfile = {
  //     name: 'John Doe',
  //     email: 'john.doe@example.com',
  //     gender: 'male',
  //     phone: '1234567890'
  //   };
  //   this.setUserProfile(initialUserProfile);
  // }

  // getUserProfile(): Observable<any> {
  //   return this.userProfile$;
  // }

  // setUserProfile(profileData: any): void {
  //   this.userProfileSubject.next(profileData);
  // }

  // saveUserProfile(profileData: any): void {
  //   // You can implement saving logic here, such as sending the data to an API
  //   console.log('Saving user profile:', profileData);
  //   // For demonstration, let's just update the local profile data
  //   this.setUserProfile(profileData);
  //   this.profileUpdated.emit(profileData);
  // }
}
}

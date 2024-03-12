import { Component ,OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup,FormControl, Validators } from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  login() {
    // Here you can implement your login logic
    // For example, you can check credentials and navigate to another page on successful login
    if (this.loginForm.valid) {
      // Assume login is successful, navigate to a dashboard page
      this.router.navigate(['/dashboard']);
    }
  }
  loginuser() {
    // Add your login logic here
  }
}
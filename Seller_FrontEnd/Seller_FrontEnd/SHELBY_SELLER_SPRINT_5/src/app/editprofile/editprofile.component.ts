import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Register } from '../model/register.model';
import { Router } from '@angular/router';
import { EditprofileService } from '../service/editprofile.service';
import { HttpErrorResponse } from '@angular/common/http';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditprofileComponent {

  form: FormGroup;
  registerDto: Register={
    id: 0,
    name: '',
    sellerEmailID: '',
    companyName: '',
    gstNumber: '',
    companyAddress: '',
    phoneNumber: 0,
    password:''
  };
 
  updateSuccess:boolean =false;
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private editprofileservice: EditprofileService
  ) {
    this.form = this.formBuilder.group({
      phoneNumber: [this.registerDto.phoneNumber, [Validators.required, Validators.pattern('^[0-9]{10}$')]],
      companyAddress:[this.registerDto.companyAddress,[Validators.required]]
    });
  }
 
  ngOnInit(): void {
    this.registerDto = JSON.parse(localStorage.getItem('registerDto') || '{}');
    // this.form = this.formBuilder.group({
    //   phonenumber: [this.buyerDto.phonenumber, [Validators.required, Validators.pattern('^((\\+91-?)|0)?[0-9]{10}$')]]
    // });
  }
 
  onSubmit(): void {
    if (this.form.valid) {
      this.registerDto.phoneNumber = this.form.value.phoneNumber;
      this.registerDto.companyAddress= this.form.value.companyAddress;
      this.editprofileservice.updateSeller(this.registerDto).subscribe(
        () => {
          this.updateSuccess = true; 
        localStorage.setItem('registerDto', JSON.stringify(this.registerDto));
        this.router.navigate(['/profile']);
        console.log("Updated successfully");

      }, 
      (error:HttpErrorResponse)=>{
       if(error.status===200){
        localStorage.setItem('registerDto', JSON.stringify(this.registerDto));
        console.log(this.registerDto.companyAddress);
        this.router.navigate(['/profile']);
        Swal.fire({
          title: "Good Job!",
          text: "Updated successfully!",
          icon: "success"
        });
       }
       // console.error('Error updating seller:', error);
       
      });
    }
  }
}

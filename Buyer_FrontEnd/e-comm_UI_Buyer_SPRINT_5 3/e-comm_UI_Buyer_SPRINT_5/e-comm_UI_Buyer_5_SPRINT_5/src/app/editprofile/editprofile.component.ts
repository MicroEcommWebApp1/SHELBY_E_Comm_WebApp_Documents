import { Component } from '@angular/core';
import { BuyerDto } from '../buyer-dto';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EditprofileService } from '../editprofile.service';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditprofileComponent {
  form: FormGroup;
  buyerDto: BuyerDto = new BuyerDto();
 
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private editprofileservice: EditprofileService
  ) {
    this.form = this.formBuilder.group({
      phonenumber: [this.buyerDto.phonenumber, [Validators.required, Validators.pattern('^((\\+91-?)|0)?[0-9]{10}$')]]
    });
  }
 
  ngOnInit(): void {
    this.buyerDto = JSON.parse(localStorage.getItem('buyerDto') || '{}');
    // this.form = this.formBuilder.group({
    //   phonenumber: [this.buyerDto.phonenumber, [Validators.required, Validators.pattern('^((\\+91-?)|0)?[0-9]{10}$')]]
    // });
  }
 
  onSubmit(): void {
    if (this.form.valid) {
      this.buyerDto.phonenumber = this.form.value.phonenumber;
      this.editprofileservice.updateBuyer(this.buyerDto).subscribe(() => {
        localStorage.setItem('buyerDto', JSON.stringify(this.buyerDto));
        this.router.navigate(['/buyer-dash']);
      }, error => {
        console.error('Error updating buyer:', error);
       
      });
    }
  }
}


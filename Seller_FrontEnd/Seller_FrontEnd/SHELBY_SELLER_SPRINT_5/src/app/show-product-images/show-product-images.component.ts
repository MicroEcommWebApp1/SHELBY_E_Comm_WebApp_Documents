import { Component, Inject } from '@angular/core';
import { FileHandle } from '../model/file-handke.model';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';


@Component({
  selector: 'app-show-product-images',
  templateUrl: './show-product-images.component.html',
  styleUrls: ['./show-product-images.component.css']
})
export class ShowProductImagesComponent {
  constructor(@Inject(MAT_DIALOG_DATA) public data:any){}

  ngOnInit():void{
    this.receiveImages();
  }

  receiveImages(){
    console.log(this.data);
   
  }

}

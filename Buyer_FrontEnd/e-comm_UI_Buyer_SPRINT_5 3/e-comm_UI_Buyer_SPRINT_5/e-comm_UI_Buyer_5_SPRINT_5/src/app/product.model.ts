import { FileHandle } from "./file-handle.model";

export interface Product{
  cartDto(cartDto: any, productId: number, quantity: number): unknown;
     productId: number;
     id: number;
     name:String;
     sellerEmailID: string,
    description:String,
    price : number,
    quantity: number,
    category : String,
    subcategory1:String,
    subcategory2 : String,
     thumbnail:String,
  productImages: FileHandle[],
  tags:String,

}
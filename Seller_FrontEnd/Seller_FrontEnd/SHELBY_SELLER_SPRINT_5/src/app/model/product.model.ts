import { FileHandle } from "./file-handke.model";

export interface Product{
    productId: any;
    id:number;
    name:String;
    sellerEmailID :String;
    description:String,
    price : number,
    quantity: number,
    category : String,
    subcategory1:String,
    subcategory2 : String,
    thumbnail:String,
    tags:String,
    productImages: FileHandle[],

}
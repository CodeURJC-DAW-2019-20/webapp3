import {Inject, Injectable, Optional} from '@angular/core';

@Injectable()
export class Product{

    public id:string;
	public  name : string;
	public  color: string;
	public  category: string;
	public  brand: string;
	public  size: string;
	public  price: number;
	public  description: string;
	public  detail: string;
	public  verify: boolean;
	public  hasImage: string;
	public  inStock: boolean;
//	private  image :byte[];

    //TO-DO : Falta añadir la Imagen del producto
    constructor(@Inject(String) name: string, @Inject(String) color: string, @Inject(String) category: string, @Inject(String) brand: string, @Inject(String) size: string, @Inject(String) description: string, @Inject(String) detail: string){
        this.id='';
        this.name = name;
        this.color= color;
        this.category=  category;
        this.brand = brand;
        this.size=size;
        this.price=0;
        this.description= description;
        this.detail= detail;
        this.verify= false;
        this.hasImage= '';
        this.inStock= false;
    
    }
}

// @ts-ignore
import {Component} from '@angular/core';
import {ProductService} from '../Product/app.productService';
import {UserService} from '../User/app.userService';
import {DataService} from '../Data/app.dataService';
import {Product} from '../Product/app.product';


@Component({
  selector: 'app-store-root',
  templateUrl: 'app.storeComponent.html',
  providers: [ProductService]
})
export class AppStoreComponent {
  constructor(private userService: UserService, private productService: ProductService, public dataService: DataService) {}
  public Products: Product[];
  public Categorys: string[];
  public Brands = [];
  public minPrice = 0;
  public maxPrice = 0;

  // tslint:disable-next-line:use-lifecycle-interface
  ngOnInit(){
    this.productService.getStock().subscribe(
      response => {
        this.Products = response;
        this.setMaxMinPrice();
        this.getBrands();
        this.getCategorys();
        console.log(response);
      },
      error => console.log('Error al solicitar el stock')
    );
  }

  public getCategorys(){
    let i = 0;
    let CategorysAux = [];
    let encontrado = true;
    for (let Product of this.Products){
        for (let j = 0; j < CategorysAux.length; j++) {
          if (CategorysAux[j] === Product.category) {
            encontrado = false;
          }
        }
        if (encontrado){
            CategorysAux[i] = Product.category;
            i++;
        }
        encontrado = true;
    }
    this.Categorys = CategorysAux;
  }

  public getBrands(){
    let i = 0;
    let BrandsAux = [];
    let encontrado = true;
    for (let Product of this.Products){
      for (let j = 0; j < BrandsAux.length; j++) {
        if (BrandsAux[j] === Product.brand) {
          encontrado = false;
        }
      }
      if (encontrado){
        BrandsAux[i] = Product.brand;
        i++;
      }
      encontrado = true;
    }
    this.Brands = BrandsAux;
  }

  public setMaxMinPrice(){
    for (let Product of this.Products){
      if (this.minPrice > Product.price){
        this.minPrice = Product.price;
      }
      if (this.maxPrice < Product.price) {
        this.maxPrice = Product.price;
      }
    }
  }
}

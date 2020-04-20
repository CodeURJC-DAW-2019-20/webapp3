// @ts-ignore
import {Component, ElementRef, ViewChild} from '@angular/core';
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
  public filtro = false;

  @ViewChild('CategoryInput') CategoryInput: ElementRef;
  private categorys: string[];

  @ViewChild('MinPriceInput') MinPriceInput: ElementRef;
  private minPriceI: number;

  @ViewChild('MaxPriceInput') MaxPriceInput: ElementRef;
  private maxPriceI: number;

  @ViewChild('BrandInput') BrandInput: ElementRef;
  private brands: string[];

  // tslint:disable-next-line:use-lifecycle-interface
  ngOnInit(){
    this.getProducts();
  }

  public getProducts(){
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

  public ordenarPorNombre(){
    for(let i = 0; i < (this.Products.length - 1); i++){
      for(let j = i + 1; j < this.Products.length; j++){
        if(this.Products[i].name > this.Products[j].name){
          let variableauxiliar = this.Products[i];
          this.Products[i] = this.Products[j];
          this.Products[j] = variableauxiliar;
        }
      }
    }
  }

  public ordenarPorPrecio(){
    for(let i = 0; i < (this.Products.length - 1); i++){
      for(let j = i + 1; j < this.Products.length; j++){
        if(this.Products[i].price > this.Products[j].price){
          let variableauxiliar = this.Products[i];
          this.Products[i] = this.Products[j];
          this.Products[j] = variableauxiliar;
        }
      }
    }
  }

  public filtrarProductos(){
    this.minPriceI = this.MinPriceInput.nativeElement.value;
    this.maxPriceI = this.MaxPriceInput.nativeElement.value;
    let ProductsByFilter = [];
    let i = 0;

    for (let Product of this.Products){
      if ((Product.price > this.minPriceI) && (Product.price < this.maxPriceI)){
        ProductsByFilter[i] = Product;
        i++;
      }
    }
    console.log(this.categorys);
    console.log(this.brands);
    this.Products = ProductsByFilter;
  }

  public addProductToLike(id: string){
    for(let Product of this.Products){
      if (Product.id === id){
        this.dataService.user.likekIts[this.dataService.user.itemsILikeIt] = Product;
        this.dataService.user.itemsILikeIt++;
      }
    }
  }

  public addProductToBasket(id: string){
    for(let Product of this.Products){
      if (Product.id === id){
        this.dataService.user.productsBasket[this.dataService.user.itemsBasket] = Product;
        this.dataService.user.itemsBasket++;
      }
    }
  }

  public setIdProductView(id: string){
    this.dataService.product.id=id;
  }

}

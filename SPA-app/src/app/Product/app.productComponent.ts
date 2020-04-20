import {Component, Inject} from '@angular/core';
import { ProductService } from './app.productService';
import {Product} from '../Product/app.product';
import { stringify } from 'querystring';
import { DataService } from '../Data/app.dataService';

@Component({
    selector: 'product-root',
    templateUrl: 'app.productComponent.html',
    providers: [ProductService]

})

export class AppProductComponent{
    constructor(private productService: ProductService, private dataService: DataService){}

        public product: Product;
        public Products = [];
        public ProducstRecommend = [];

    ngOnInit(id: string){
        this.productService.getProduct(this.dataService.product.id).subscribe(
            response => {
                this.product = response;
                console.log(response);
            },
            error => console.log('Error al solicitar el producto')
            );
      this.getProducts();
    }

    public getProducts(){
      this.productService.getStock().subscribe(
        response => {
          this.Products = response;
          console.log(response);
        },
        error => console.log('Error al solicitar el stock')
      );
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
}

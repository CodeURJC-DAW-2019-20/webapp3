// @ts-ignore
import {Component} from '@angular/core';
import {ProductService} from '../Product/app.productService';
import {UserService} from '../User/app.userService';
import {DataService} from '../Data/app.dataService';
import {Product} from '../Product/app.product';


@Component({
  selector: 'app-likeit-root',
  templateUrl: 'app.basketComponent.html',
  providers: [ProductService]
})
export class AppBasketComponent {
  constructor(private userService: UserService, private productService: ProductService, public dataService: DataService) {}
  public Products: Product[];
  public priceofBasket = 0;


  // tslint:disable-next-line:use-lifecycle-interface
  ngOnInit(){
    this.Products = this.dataService.user.productsBasket;
    this.setPriceOfBasket();
  }

  public addProductToLike(id: string){
    for(let Product of this.Products){
      if (Product.id === id){
        this.dataService.user.likekIts[this.dataService.user.itemsILikeIt] = Product;
        this.dataService.user.itemsILikeIt++;
      }
    }
  }

  public setPriceOfBasket (){
    for (let i = 0; i < this.Products.length; i++){
      this.priceofBasket += this.Products[i].price;
    }
  }

  public setIdProductView(id: string){
    this.dataService.product.id = id;

  }

}

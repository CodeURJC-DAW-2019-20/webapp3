import {Component} from '@angular/core';
import {UserService} from '../User/app.userService';
import {ProductService} from '../Product/app.productService';
import {DataService} from '../Data/app.dataService';
import {Product} from '../Product/app.product';

@Component({
  selector: 'app-checkout-root',
  templateUrl: 'app.checkoutComponent.html',
})
export class AppCheckoutComponent {
  constructor(public dataService: DataService){}
  public Products: Product[];
  public priceOfBasket = 0;
  ngOnInit(){
    this.Products = this.dataService.user.productsBasket;
    this.setPriceOfBasket();
  }

  public setPriceOfBasket (){
    for (let i = 0; i < this.Products.length; i++){
      this.priceOfBasket += this.Products[i].price;
    }
  }

  public checkout (){
    if (this.dataService.user.puntos >= this.priceOfBasket){
      this.dataService.user.puntos = this.dataService.user.puntos - this.priceOfBasket;
    }
  }
}

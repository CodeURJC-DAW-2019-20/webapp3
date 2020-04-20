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
  constructor(private userService: UserService, private productService: ProductService, public dataService: DataService){}
  public Products: Product[];
  // tslint:disable-next-line:use-lifecycle-interface
  ngOnInit(){
    this.Products = this.dataService.user.productsBasket;
  }
}

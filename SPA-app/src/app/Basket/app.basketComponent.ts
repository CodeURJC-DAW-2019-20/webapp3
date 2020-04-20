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


  // tslint:disable-next-line:use-lifecycle-interface
  ngOnInit(){}

}
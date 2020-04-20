// @ts-ignore
import {Component} from '@angular/core';
import {ProductService} from '../Product/app.productService';
import {UserService} from '../User/app.userService';
import {DataService} from '../Data/app.dataService';
import {Product} from '../Product/app.product';


@Component({
  selector: 'app-likeit-root',
  templateUrl: 'app.likeItComponent.html',
  providers: [ProductService]
})
export class AppLikeItComponent {
  constructor(private userService: UserService, private productService: ProductService, public dataService: DataService) {}
  public Products: Product[];
  public Categorys: string[];
  public Brands = [];
  public minPrice = 0;
  public maxPrice = 0;

  // tslint:disable-next-line:use-lifecycle-interface
  ngOnInit(){}

}

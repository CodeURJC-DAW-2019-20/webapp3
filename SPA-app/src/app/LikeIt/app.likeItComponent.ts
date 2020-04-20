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

  // tslint:disable-next-line:use-lifecycle-interface
  ngOnInit(){
    this.Products = this.dataService.user.likekIts;
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

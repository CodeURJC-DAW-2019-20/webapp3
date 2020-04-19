// @ts-ignore
import {Component} from '@angular/core';
import {LoginComponent} from '../Login/app.loginComponent';
import {ProfileComponent} from '../Profile/app.profileComponent';
import {ProductService} from '../Product/app.productService';
import {UserService} from '../User/app.userService';
import {DataService} from '../Data/app.dataService';
import {Product} from '../Product/app.product';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-index-root',
  templateUrl: 'app.indexComponent.html',
  providers: [ProductService]
})
export class AppIndexComponent {
  constructor(private userService: UserService, private productService: ProductService, public dataService: DataService) {}
  public Products: Product[];

  // tslint:disable-next-line:use-lifecycle-interface
  ngOnInit(){
    this.productService.getStock().subscribe(
      response => {
        this.Products = response;
        console.log(response);
      },
      error => console.log('Error al solicitar el stock')
    );
  }
}


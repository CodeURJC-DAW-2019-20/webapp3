import {Component, ElementRef, ViewChild} from '@angular/core';
import {UserService} from '../User/app.userService';
import {ProductService} from '../Product/app.productService';
import {DataService} from '../Data/app.dataService';

@Component({
  selector: 'app-header-root',
  templateUrl: 'app.headerComponent.html',
  providers: [UserService, ProductService]
})
export class AppHeaderComponent {
  constructor(private userService: UserService, private productService: ProductService, public dataService: DataService){}
}

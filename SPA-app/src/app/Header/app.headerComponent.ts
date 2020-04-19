import {Component} from '@angular/core';
import {UserService} from '../User/app.userService';
import {ProductService} from '../Product/app.productService';
import {DataService} from '../Data/app.dataService';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header-root',
  templateUrl: 'app.headerComponent.html',
  providers: [UserService, ProductService]
})
export class AppHeaderComponent {
  constructor(private userService: UserService, private router: Router, public dataService: DataService){}

  goToLogin(){
    this.router.navigate(['/login']);
  }
}

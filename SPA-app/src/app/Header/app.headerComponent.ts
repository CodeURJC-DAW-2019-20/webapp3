import {Component, Input, OnInit} from '@angular/core';
import {UserService} from '../User/app.userService';
import {ProductService} from '../Product/app.productService';
import {DataService} from '../Data/app.dataService';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-header-root',
  templateUrl: 'app.headerComponent.html',
  providers: [UserService, ProductService]
})
export class AppHeaderComponent {
  constructor(private userService: UserService, activatedRoute: ActivatedRoute, private router: Router, public dataService: DataService){}

  goToLogin(){
    this.router.navigate(['/login']);
  }

}

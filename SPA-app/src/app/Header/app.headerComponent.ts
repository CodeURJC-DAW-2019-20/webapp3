import {Component, Input, OnInit} from '@angular/core';
import {UserService} from '../User/app.userService';
import {ProductService} from '../Product/app.productService';
import {DataService} from '../Data/app.dataService';
import {ActivatedRoute, Router} from '@angular/router';
import {User} from '../User/app.user';

@Component({
  selector: 'app-header-root',
  templateUrl: 'app.headerComponent.html',
  providers: [UserService, ProductService]
})
export class AppHeaderComponent {
  constructor(public dataService: DataService){}

  logoutUser(){
    this.dataService.user = new User('Usuario', 'Contraseña', 'apellido', 'email', 'direccion', 'ciudad', 'pais', 'c.d.', 'Telefono');
  }
}

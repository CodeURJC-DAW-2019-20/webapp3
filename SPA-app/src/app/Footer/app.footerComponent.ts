// @ts-ignore
import {Component} from '@angular/core';
import {UserService} from '../User/app.userService';
import {ActivatedRoute, Router} from '@angular/router';
import {DataService} from '../Data/app.dataService';

@Component({
  selector: 'app-footer-root',
  templateUrl: 'app.footerComponent.html',
})

export class AppFooterComponent{
  constructor(public dataService: DataService){}
}

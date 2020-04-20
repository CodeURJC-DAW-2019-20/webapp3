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
  constructor(private userService: UserService, activatedRoute: ActivatedRoute, private router: Router, public dataService: DataService){}
}

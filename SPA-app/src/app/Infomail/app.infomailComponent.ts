// @ts-ignore
import {Component, ElementRef, ViewChild} from '@angular/core';
import {UserService} from '../User/app.userService';
import {DataService} from '../Data/app.dataService';

@Component({
  selector: 'app-infomail-root',
  templateUrl: 'app.infomailComponent.html',
})
export class AppInfomailComponent {
  constructor(){}

  @ViewChild('nameInput') nameInput: ElementRef;
  private name: string;

  @ViewChild('lastnameInput') lastnameInput: ElementRef;
  private lastname: string;

  @ViewChild('emailInput') emailInput: ElementRef;
  private email: string;

  @ViewChild('emailInput') messageInput: ElementRef;
  private message: string;
}

// @ts-ignore
import {Component, ElementRef, Inject, ViewChild} from '@angular/core';
import {UserService} from '../User/app.userService';
import {DataService} from '../Data/app.dataService';
import {User} from "../User/app.user";
import {HttpHeaders} from "@angular/common/http";
import {SuggestionService} from '../Suggestion/app.suggestionService';
import {Suggestion} from '../Suggestion/app.suggestion';

@Component({
  selector: 'app-infomail-root',
  templateUrl: 'app.infomailComponent.html',
})
export class AppInfomailComponent {
  constructor(private suggestionService: SuggestionService){}

  @ViewChild('nameInput') nameInput: ElementRef;
  private name: string;

  @ViewChild('lastnameInput') lastnameInput: ElementRef;
  private lastname: string;

  @ViewChild('emailInput') emailInput: ElementRef;
  private email: string;

  @ViewChild('messageInput') messageInput: ElementRef;
  private message: string;

  registerInfo() {
    this.name = this.nameInput.nativeElement.value;
    this.lastname = this.lastnameInput.nativeElement.value;
    this.email = this.emailInput.nativeElement.value;
    this.message = this.messageInput.nativeElement.value;
    if ( this.checkField(this.name) && (this.checkField(this.lastname)) &&
      this.checkField(this.email) && (this.checkField(this.message))){
      const infomail = new Suggestion(this.name, this.lastname, this.email, this.message);
      this.suggestionService.registerInfo(infomail).subscribe(
        response => {
          console.log(response);
          alert('Su petición ha sido enviada');
        },
        error => console.log('Su petición NO ha sido enviada')
      );
    }

  }

  checkField(field: string): boolean{
    if (field != '') {
      return true;
    }
    return false;
  }
}


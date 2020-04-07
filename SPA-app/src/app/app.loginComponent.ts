import { Component, ViewChild, ElementRef} from '@angular/core';
import {LoginService} from './app.loginService';
import {User} from './app.user';

@Component({
    selector:'login-root',
    templateUrl: './app.loginComponent.html',
   //providers: ['LoginService']
})

export class LoginComponent{
    constructor(private loginService: LoginService){};
    //Login form

    @ViewChild('userInput') userInput:ElementRef;
    private user: string;

    @ViewChild('passInput') passInput:ElementRef;
    private pass: string;

    //Register form

    @ViewChild('nameInput') nameInput:ElementRef;
    private name: string;

    @ViewChild('passwordInput') passwordInput:ElementRef;
    private password: string;

    @ViewChild('lastnameInput') lastnameInput:ElementRef;
    private lastname: string;

    @ViewChild('emailInput') emailInput:ElementRef;
    private email: string;

    @ViewChild('addresInput') addresInput:ElementRef;
    private addres: string;

    @ViewChild('cityInput') cityInput:ElementRef;
    private city: string;

    @ViewChild('countryInput') countryInput:ElementRef;
    private country: string;

    @ViewChild('cpInput') cpInput:ElementRef;
    private cp: string;

    @ViewChild('phoneInput') phoneInput:ElementRef;
    private phone: string;  
    
    userLogin(){
        this.user=this.userInput.nativeElement.value;
        this.pass=this.passInput.nativeElement.value;

        if(this.checkField(this.user) && (this.checkField(this.pass))){
            alert('usser name: '+ this.user +
                 '  pass : '+ this.pass );
        }
    }

    registerUser(){
        this.name=this.nameInput.nativeElement.value;
        this.password=this.passwordInput.nativeElement.value;
        this.lastname=this.lastnameInput.nativeElement.value;
        this.email=this.emailInput.nativeElement.value;
        this.addres=this.addresInput.nativeElement.value;
        this.city=this.cityInput.nativeElement.value;
        this.country=this.countryInput.nativeElement.value;
        this.cp=this.cpInput.nativeElement.value;
        this.phone=this.phoneInput.nativeElement.value;

        if( this.checkField(this.name) && (this.checkField(this.password)) && (this.checkField(this.lastname)) &&
            this.checkField(this.email) && (this.checkField(this.addres)) &&
            this.checkField(this.city) && (this.checkField(this.country)) &&
            this.checkField(this.cp) && (this.checkField(this.phone))){
                let user= new User(this.name,this.pass,this.lastname,this.email,this.addres,this.city,this.country,this.cp,this.phone);
                user.printUser();
                this.loginService.registerUser(user);
        }
       
    }
    
    checkField(field:string):boolean{
        if(field != '')
            return true;
        return false;
    }

}
import { Component, ViewChild, ElementRef} from '@angular/core';
import {UserService} from '../User/app.userService';
import {User} from '../User/app.user';
import { HttpErrorResponse } from '@angular/common/http';
import { DataService } from '../Data/app.dataService';

@Component({
  // tslint:disable-next-line:component-selector
    selector: 'login-root',
    templateUrl: './app.loginComponent.html',
    providers: [UserService]
})

export class LoginComponent{
    constructor(private userService: UserService, private dataservice: DataService){}

    // Login form

    @ViewChild('userInput') userInput: ElementRef;
    private userName: string;

    @ViewChild('passInput') passInput: ElementRef;
    private userPass: string;

    // Register form

    @ViewChild('nameInput') nameInput: ElementRef;
    private name: string;

    @ViewChild('passwordInput') passwordInput: ElementRef;
    private password: string;

    @ViewChild('lastnameInput') lastnameInput: ElementRef;
    private lastname: string;

    @ViewChild('emailInput') emailInput: ElementRef;
    private email: string;

    @ViewChild('addresInput') addresInput: ElementRef;
    private address: string;

    @ViewChild('cityInput') cityInput: ElementRef;
    private city: string;

    @ViewChild('countryInput') countryInput: ElementRef;
    private country: string;

    @ViewChild('cpInput') cpInput: ElementRef;
    private cp: string;

    @ViewChild('phoneInput') phoneInput: ElementRef;
    private phone: string;

    ngOnInit(){

    }

    userLogin(){
        this.userName = this.userInput.nativeElement.value;
        this.userPass = this.passInput.nativeElement.value;

        if (this.checkField(this.userName) && (this.checkField(this.userPass))){

            this.userService.getUserByName(this.userName, this.userPass).subscribe(
                response => {
                    console.log(response);
                    const user: User = response;
                    this.dataservice.user = response;
                    // alert(user.getPass());
                /*    this.user = response;
                    this.user.setPass(this.userPass);
                    alert( this.user.getName());
                    */alert('respuesta');

                },
                (error: HttpErrorResponse) => alert(error.message)
            );
            alert('getUser');
        }
    }

    registerUser(){
        this.name = this.nameInput.nativeElement.value;
        this.password = this.passwordInput.nativeElement.value;
        this.lastname = this.lastnameInput.nativeElement.value;
        this.email = this.emailInput.nativeElement.value;
        this.address = this.addresInput.nativeElement.value;
        this.city = this.cityInput.nativeElement.value;
        this.country = this.countryInput.nativeElement.value;
        this.cp = this.cpInput.nativeElement.value;
        this.phone = this.phoneInput.nativeElement.value;

        if ( this.checkField(this.name) && (this.checkField(this.password)) && (this.checkField(this.lastname)) &&
            this.checkField(this.email) && (this.checkField(this.address)) &&
            this.checkField(this.city) && (this.checkField(this.country)) &&
            this.checkField(this.cp) && (this.checkField(this.phone))){
                const user = new User(this.name, this.password, this.lastname, this.email, this.address, this.city, this.country, this.cp, this.phone);
                this.userService.registerUser(user).subscribe(
                    response => {
                        console.log(response);
                        alert('El usuario ha sido registrado exitosamente. Verifique su email para activarlo');
                    },
                    error => console.log('Error al registrar al usuario')
                );
                alert('Se ha solicitado la peticion de registro');
        }

    }

    checkField(field: string): boolean{
        if (field != '') {
            return true;
        }
        return false;
    }

}

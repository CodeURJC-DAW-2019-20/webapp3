import { Component, ViewChild, ElementRef, Input} from '@angular/core';
import {UserService} from '../User/app.userService';
import { FormsModule} from '@angular/forms';
import { NgModule } from '@angular/core';
import {User} from '../User/app.user';
import { HttpErrorResponse } from '@angular/common/http';
import { DataService } from '../Data/app.dataService';
import { ProductService } from '../Product/app.productService';

@Component({
  // tslint:disable-next-line:component-selector
    selector: 'profile-root',
    templateUrl: './app.profileComponent.html',
    providers: [UserService, ProductService]
})

export class ProfileComponent {
    constructor(private userService: UserService, private productService: ProductService, public dataService: DataService){}

    @ViewChild('nameInput') nameInput: ElementRef;
    private name: string;

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

    active = 1;

    // Para probar los metodos
    ngOnInit(){
        this.productService.getStock().subscribe(
            response => {
                console.log(response);
                alert('Stock recibido');
            },
            error => console.log('Error al solicitar el stock')
        );

        this.productService.getPreStock('Admin', 'adminpass').subscribe(
            response => {
                console.log(response);
                alert('Stock recibido');
            },
            error => console.log('Error al solicitar el stock')
        );

        this.userService.getAllUser('Admin', 'adminpass').subscribe(
            response => {
                console.log(response);
                alert('Stock recibido');
            },
            error => console.log('Error al solicitar el stock')
        );
    }



    updateUser(){
        this.name = this.nameInput.nativeElement.value;
        this.lastname = this.lastnameInput.nativeElement.value;
        this.email = this.emailInput.nativeElement.value;
        this.address = this.addresInput.nativeElement.value;
        this.city = this.cityInput.nativeElement.value;
        this.country = this.countryInput.nativeElement.value;
        this.cp = this.cpInput.nativeElement.value;
        this.phone = this.phoneInput.nativeElement.value;

        if( this.checkField(this.name)  && (this.checkField(this.lastname)) &&
            this.checkField(this.email) && (this.checkField(this.address)) &&
            this.checkField(this.city) && (this.checkField(this.country)) &&
            this.checkField(this.cp) && (this.checkField(this.phone))){

                let user = new User(this.name, prompt('Introduzca su contraseña para realizar la operacion'), this.lastname, this.email, this.address, this.city, this.country, this.cp, this.phone);
                this.userService.updateUser(user).subscribe(
                    response => {
                        console.log(response);
                        alert('Los datos del Usuario han sido actualizados exitosamente');
                    },
                    error => console.log('Error al actualizar al usuario')
                );
                alert('Se ha solicitado la peticion de actualizar los datos del usuario');
        }
    }

    checkField(field: string): boolean{
        if (field != '')
            return true;
        return false;
    }
  }

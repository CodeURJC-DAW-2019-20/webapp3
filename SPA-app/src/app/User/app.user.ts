import {Inject, Injectable, Optional} from '@angular/core';
import {Product} from '../Product/app.product';

@Injectable()
export class User{

    public id: number;
    public name: string;
    public passwordHash: string;
    public roles: String[];
    public lastname: string;
    public email: string;
    public address: string;
    public city: string;
    public country: string;
    public cp: string;
    public phone: string;
    public puntos: number;
    public emailVerified: boolean;
    public login: boolean;
    public itemsILikeIt: number;
    public itemsBasket: number;
    public likekIts: Product[];
    public productsBasket: Product[];
    public isAdmin:boolean;

    constructor(@Inject(String) name: string, @Inject(String) passwordHash: string, @Inject(String) lastname: string, @Inject(String) email: string, @Inject(String) address: string, @Inject(String) city: string, @Inject(String) country: string, @Inject(String) cp: string, @Inject(String) phone: string){
        this.id = -1;
        this.name = name;
        this.passwordHash =  passwordHash;
        this.roles = [];
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
        this.cp = cp;
        this.phone = phone;
        this.puntos = 0;
        this.emailVerified = false;
        this.login = false;
        this.itemsILikeIt = 0;
        this.itemsBasket = 0;
        this.productsBasket = [];
        this.likekIts = [];
        this.isAdmin=false;

    }


    public getName(){
        return this.name;
    }

    public setPass(pass: string){
        this.passwordHash = pass;
    }
    public getPuntos(){
      return this.puntos;
    }

    public getPass(){
        return this.passwordHash;
    }

    public setLogin(value: boolean){
        this.login = value;
    }


    public isAdminFunction(): boolean{
        console.log(this.passwordHash+ '  user:(')
       return (this.passwordHash == 'adminpass');
        /* this.roles.forEach(element => {
            if(element == "ROLE_ADMIN" )
                return true;
        });
        return false;
       // return this.roles.includes("ROLE_ADMIN");
       */
    }

    public stringUser(){
        return 'nombre: ' + this.name + ' | ' +
            'lastname: ' + this.lastname + ' | ' +
            'email: ' + this.email + ' | ' ;
    }
}

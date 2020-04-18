import {Inject, Injectable, Optional} from '@angular/core';
import {Product} from '../Product/app.product'

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
    private puntos: number;
    public emailVerified: boolean;
    public login : boolean;
    public itemsIlikeIt: number;
    public itemsBasket: number;
    public likekIts:Product[];

    //constructor(name, passworHash, lastname, email, addres, city, country, cp, phone){

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
        this.itemsIlikeIt = 0;
        this.itemsBasket = 0;
        this.likekIts = [];
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

    public stringUser(){
        return 'nombre: ' + this.name + ' | ' +
            'lastname: ' + this.lastname + ' | ' +
            'email: ' + this.email + ' | ' ;
    }
}

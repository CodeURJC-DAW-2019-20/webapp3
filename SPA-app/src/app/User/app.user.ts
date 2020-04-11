import {Inject, Injectable, Optional} from '@angular/core';

@Injectable()
export class User{

    private id: number;
    private name: string;
    private passwordHash: string;
    private roles : String[];
    private lastname: string;
    private email: string;
    private address: string;
    private city: string;
    private country: string;
    private cp: string;
    private phone: string;
    private puntos: number;
    private emailVerified: boolean;
    private login : boolean;
    private itemsIlikeIt: number;
    private itemsBasket: number;
    //private likekIts:Products[];

    //constructor(name, passworHash, lastname, email, addres, city, country, cp, phone){

    constructor(@Inject(String) name: string, @Inject(String) passwordHash: string, @Inject(String) lastname: string, @Inject(String) email: string, @Inject(String) address: string, @Inject(String) city: string, @Inject(String) country: string, @Inject(String) cp: string, @Inject(String) phone: string){
        this.id = -1;
        this.name= name;
        this.passwordHash=  passwordHash;
        this.roles = [];
        this.lastname=lastname;
        this.email=email;
        this.address= address;
        this.city= city;
        this.country= country;
        this.cp= cp;
        this.phone= phone;
        this.puntos=0;
        this.emailVerified=false;
        this.login = false;
        this.itemsIlikeIt=0;
        this.itemsBasket=0;
    }

    printUser(){
        alert('nombre: ' + this.name + ' | ' +
            'lastname: ' + this.lastname + ' | ' +
            'email: ' + this.email + ' | ' );
    }
}

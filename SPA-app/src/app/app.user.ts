import {Injectable} from '@angular/core';

@Injectable()
export class User{
   
    private id: number;
    private name: string;
    private passworHash: string;
    private roles : String[];
    private lastname: string;
    private email: string;
    private addres: string;
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
    constructor(name: string, passworHash: string, lastname: string, email: string, addres: string, city: string, country: string, cp: string, phone: string){
        this.id = -1;
        this.name= name;
        this.passworHash=  passworHash;
        this.roles = [];
        this.lastname=lastname;
        this.email=email;
        this.addres= addres;
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
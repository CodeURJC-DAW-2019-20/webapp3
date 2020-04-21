import { Component, ViewChild, ElementRef, Input} from '@angular/core';
import {UserService} from '../User/app.userService';
import { FormsModule} from '@angular/forms';
import { NgModule } from '@angular/core';
import {User} from '../User/app.user';
import {Product} from '../Product/app.product';
import {Suggestion} from '../Suggestion/app.suggestion';
import { HttpErrorResponse } from '@angular/common/http';
import { DataService } from '../Data/app.dataService';
import { ProductService } from '../Product/app.productService';
import { SuggestionService } from '../Suggestion/app.suggestionService';
import { CompileShallowModuleMetadata } from '@angular/compiler';


@Component({
  // tslint:disable-next-line:component-selector
    selector: 'profile-root',
    templateUrl: './app.profileComponent.html',
    providers: [UserService, ProductService]
})

export class ProfileComponent {
    constructor(private userService: UserService, private productService: ProductService, public dataService: DataService,private suggestionService:SuggestionService){}

    public userList: User[];
    public stock: Product[];
    public preStock: Product[];
    public suggestionList: Suggestion[];
    public isAdmin:boolean;

    // DATA USER/ADMIN (VARIABLES)
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

    //CREATE PRODUCT (VARIABLES)
    @ViewChild('newNameProductInput') newNameProductInput: ElementRef;
    private newNameProduct: string;
    @ViewChild('newColorProductInput') newColorProductInput: ElementRef;
    private newColorProduct: string;
    @ViewChild('newCategoryProductInput') newCategoryProductInput: ElementRef;
    private newCategoryProduct: string;
    @ViewChild('newBrandProductInput') newBrandProductInput: ElementRef;
    private newBrandProduct: string;
    @ViewChild('newSizeProductInput') newSizeProductInput: ElementRef;
    private newSizeProduct: string;
    @ViewChild('newDescriptionProductInput') newDescriptionProductInput: ElementRef;
    private newDescriptionProduct: string;
    @ViewChild('newDetailProductInput') newDetailProductInput: ElementRef;
    private newDetailProduct: string;

     img : File =null;

    active = 1;

    // Para probar los metodos
    ngOnInit(){
        this.isAdmin=this.dataService.user.isAdmin;
        console.log(this.isAdmin);
        this.getUserList(this.dataService.user.name,this.dataService.user.passwordHash);
    }

    isAdministrator(){
        this.isAdmin=this.dataService.user.isAdmin;
        console.log(this.isAdmin);
    }

    onFileSelected(event){
        this.img= <File> event.target.files[0];
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

                let user = new User(this.name, this.dataService.user.passwordHash, this.lastname, this.email, this.address, this.city, this.country, this.cp, this.phone);
                this.userService.updateUser(user,this.dataService.user.name,this.dataService.user.passwordHash).subscribe(
                    response => {
                        console.log(response);
                    },
                    error => console.log('Error al actualizar al usuario')
                );
        }
    }

    getStock(){
        this.productService.getStock().subscribe(
            response => {
                this.stock=response;
                console.log(response);
            },
            error => console.log('Error al solicitar el stock')
        );
    }

    getPreStock(name:string,pass:string){
        this.productService.getPreStock(name,pass).subscribe(
            response => {                 
                this.preStock=response;
                console.log(response);              
            },
            error => console.log('Error al solicitar el stock')
        );
    }

    getUserList(name:string,pass:string){
        this.userService.getAllUser(name,pass).subscribe(
            response => {
                this.userList=response;
                console.log(response);
            },
            error => console.log('Error al solicitar el stock')
        );
    }

    getSuggestionList(name:string,pass:string){
        this.suggestionService.getSuggestionList(name,pass).subscribe(
            response => {
                this.suggestionList=response;
                console.log(response);
            },
            error => console.log('Error al solicitar el stock')
        );
    }

    createProduct(){
        this.newNameProduct=this.newNameProductInput.nativeElement.value;
        this.newColorProduct= this.newColorProductInput.nativeElement.value;
        this.newCategoryProduct= this.newCategoryProductInput.nativeElement.value;
        this.newBrandProduct = this.newBrandProductInput.nativeElement.value;
        this.newSizeProduct = this.newSizeProductInput.nativeElement.value;
        this.newDescriptionProduct= this.newDescriptionProductInput.nativeElement.value;
        this.newDetailProduct = this.newDetailProductInput.nativeElement.value;

        let newProduct : Product = new Product(this.newNameProduct,this.newColorProduct, this.newCategoryProduct,this.newBrandProduct,this.newSizeProduct,this.newDescriptionProduct,this.newDetailProduct);
        if(this.checkField(newProduct.name) && this.checkField(newProduct.color) &&
           this.checkField(newProduct.category) && this.checkField(newProduct.brand) &&
           this.checkField(newProduct.size) && this.checkField(newProduct.description)  &&
           this.checkField(newProduct.detail) && this.checkField(this.img.name)
        ){
            console.log(newProduct);
            this.productService.loadProduct(newProduct,this.dataService.user.name,this.dataService.user.passwordHash).subscribe(
                response => {
                    console.log(response);
                    this.productService.loadImageProduct(this.img,response.id,this.dataService.user.name,this.dataService.user.passwordHash).subscribe(
                        response => {
                            console.log(response);                           
                        },
                        error => console.log('Error al crear la Imagen del Producto')
                    );

                },
                error => console.log('Error al crear el Producto')
            );
        }
    }

    checkField(field: string): boolean{
        if (field != '')
            return true;
        return false;
    }
   
    deleteSuggestion(index:number){
        this.suggestionService.deleteSuggestion(this.suggestionList[index].name,this.dataService.user.name,this.dataService.user.passwordHash).subscribe(
            response => {
                console.log(response);                           
            },
            error => console.log('Error al borra el Usuario')
        );
    }

    deleteUser(index:number){
        console.log(this.userList[index].name);
        this.userService.deleteUser(this.userList[index].name,this.dataService.user.name,this.dataService.user.passwordHash).subscribe(
            response => {
                console.log(response);                           
            },
            error => console.log('Error al borra el Usuario')
        );
    }

    modifyUser(index:number){
        console.log(index);
        console.log(this.userList[index]);
        this.userService.updateUser(this.userList[index],this.dataService.user.name,this.dataService.user.passwordHash).subscribe(
            response => {
                console.log(response);                           
            },
            error => console.log('Error al Modificar el Usuario')
        );    
    }

    deletePreProduct(index:number){
        this.productService.deleteProduct(this.preStock[index].id,this.dataService.user.name,this.dataService.user.passwordHash).subscribe(
            response => {
                console.log(response);                           
            },
            error => console.log('Error al Borrar el articulo de prestock')
        );  
    }

    deleteProduct(index:number){
        this.productService.deleteProduct(this.stock[index].id,this.dataService.user.name,this.dataService.user.passwordHash).subscribe(
            response => {
                console.log(response);                           
            },
            error => console.log('Error al Borrar el articulo')
        );  
    }
    validarPreProduct(index:number){
        this.productService.validarPreProduct(this.preStock[index],this.dataService.user.name,this.dataService.user.passwordHash).subscribe(
            response => {
                console.log(response);                           
            },
            error => console.log('Error al Validar el articulo de prestock')
        );  
    }
}
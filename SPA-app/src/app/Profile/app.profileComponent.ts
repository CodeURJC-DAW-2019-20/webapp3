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
import { ProductPage } from '../Product/app.ProductPage';


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
    
    // PAGE USER
    public pageUserIndex:number=0;
    public pageUserSize:number=4;
    public totalPagesUser:number=1;

    // PAGE STOCK
    public pageStockIndex:number=0;
    public pageStockSize:number=4;
    public totaPagesStock:number=2;
   
    // PAGE PRESTOCK
    public pagePreStockIndex:number=0;
    public pagePreStockSize:number=4;
    public totaPagesPreStock:number=2;

    // PAGE PRESTOCK
    public pageSuggestionIndex:number=0;
    public pageSuggestionSize:number=4;
    public totalPagesSuggestion:number=2;



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

     img: File =null;

    active = 1;

    ngOnInit(){
        
        this.isAdmin=this.dataService.user.isAdmin;
        console.log(this.isAdmin);
        this.configUserPage(' ');

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
                this.userService.updateUser(user, this.dataService.user.name, this.dataService.user.passwordHash).subscribe(
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

    configStockPage(select:string){      
        if (select=='next'){
            if( this.pageStockIndex < this.totaPagesStock-1){
                this.pageStockIndex++;
                this.getStockPage(this.pageStockIndex,this.pageStockSize)
            }
                
        }else if (select=='previous' && this.pageStockIndex > 0){
            this.pageStockIndex--;
            this.getStockPage(this.pageStockIndex,this.pageStockSize)
        }else{
            this.pageStockIndex=0; 
            this.getStockPage(this.pageStockIndex,this.pageStockSize) 
        } 
        
    }

    getStockPage(index:number,size:number){
        this.productService.getStockPage(index,size).subscribe(
            response => {
                console.log(response);
                this.stock=response.content;
                this.totaPagesStock=response.totalPages;
            },
            error => console.log('Error alsolicitar la pagina de Stock')
        );
    }

    configPreStockPage(select:string){      
        if (select=='next'){
            if( this.pagePreStockIndex < this.totaPagesPreStock-1){
                this.pagePreStockIndex++;
                this.getPreStockPage(this.pagePreStockIndex,this.pagePreStockSize)
            }
                
        }else if (select=='previous' && this.pagePreStockIndex > 0){
            this.pagePreStockIndex--;
            this.getPreStockPage(this.pagePreStockIndex,this.pagePreStockSize)
        }else{
            this.pagePreStockIndex=0; 
            this.getPreStockPage(this.pagePreStockIndex,this.pagePreStockSize) 
        } 
        
    }

    getPreStockPage(index:number,size:number){
        this.productService.getPreStockPage(index,size,this.dataService.user.name,this.dataService.user.passwordHash).subscribe(
            response => {
                console.log(response);
                this.preStock=response.content;
                this.totaPagesPreStock=response.totalPages;
            },
            error => console.log('Error alsolicitar la pagina de Stock')
        );
    }

    configUserPage(select:string){      
        if (select=='next'){
            if( this.pageUserIndex < this.totalPagesUser-1){
                this.pageUserIndex++;
                this.getUserPage(this.pageUserIndex,this.pageUserSize)
            }
                
        }else if (select=='previous' && this.pageUserIndex > 0){
            this.pageUserIndex--;
            this.getUserPage(this.pageUserIndex,this.pageUserSize)
        }else{
            this.pageUserIndex=0; 
            this.getUserPage(this.pageUserIndex,this.pageUserSize) 
        } 
        
    }

    getUserPage(index:number,size:number){
        this.userService.getUserPage(index,size,this.dataService.user.name,this.dataService.user.passwordHash).subscribe(
            response => {
                console.log(response);
                this.userList=response.userList;
                this.totalPagesUser=response.totalPages;
            },
            error => console.log('Error alsolicitar la pagina de Stock')
        );
    }

    configSuggestionPage(select:string){      
        if (select=='next'){
            if( this.pageSuggestionIndex < this.totalPagesSuggestion-1){
                this.pageSuggestionIndex++;
                this.getSuggestionPage(this.pageSuggestionIndex,this.pageSuggestionSize)
            }
                
        }else if (select=='previous' && this.pageSuggestionIndex > 0){
            this.pageSuggestionIndex--;
            this.getSuggestionPage(this.pageSuggestionIndex,this.pageSuggestionSize)
        }else{
            this.pageSuggestionIndex=0; 
            this.getSuggestionPage(this.pageSuggestionIndex,this.pageSuggestionSize) 
        } 
        
    }

    getSuggestionPage(index:number,size:number){
        this.suggestionService.getSuggestionPage(index,size,this.dataService.user.name,this.dataService.user.passwordHash).subscribe(
            response => {
                console.log(response);
                this.suggestionList=response.content;
                this.totalPagesSuggestion=response.totalPages;
            },
            error => console.log('Error alsolicitar la pagina de Stock')
        );
    }
}

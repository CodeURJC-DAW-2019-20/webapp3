import {Injectable,Inject} from '@angular/core';
import {Product} from './app.product';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';

@Injectable({providedIn: 'root'})
export class ProductService{
    constructor(private http: HttpClient){}
    url: string = 'https://localhost:8443/api/product/';

    public getStock(){
        return this.http.get<Product[]>(this.url + 'stock',{
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
            })
        });
    }

    public getPreStock(name: string, pass: string){
        return this.http.get<Product[]>(this.url + 'prestock',{
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + btoa(name + ':' + pass)
            })
        });
    }

    public getProduct(id: string){
        return this.http.get<Product>(this.url +'?id='+id,{
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
            })
        });
    }


}

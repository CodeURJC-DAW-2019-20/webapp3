import {Injectable,Inject} from '@angular/core';
import {Product} from './app.product';
import { HttpClient, HttpRequest, HttpHeaders } from '@angular/common/http';

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

    public loadProduct(product:Product , name: string, pass: string){
        return this.http.post<Product>(this.url + 'load',product,{
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + btoa(name + ':' + pass)
            })
        }); 
    }

    public loadImageProduct(img:File, id:string , name: string, pass: string){
        console.log(id+'|'+img.name +'--'+ img);
        const fd : FormData = new FormData();
        fd.append('imagenFile',img);

        const newRequest = new HttpRequest('POST', this.url + id+'/imagen', fd, {
                reportProgress: true,
                responseType: 'text',
                headers: new HttpHeaders({
                    'Authorization': 'Basic ' + btoa(name + ':' + pass)
            })
        });
        return this.http.request(newRequest);
 
    }

    public deleteProduct(id:string , name: string, pass: string){
        console.log(id);
        return this.http.delete<any>(this.url + 'modify?id='+id,{
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + btoa(name + ':' + pass)
            })
        }); 
    }

    public validarPreProduct(product:Product , name: string, pass: string){
        console.log(product.id+ ' | '+name+' | '+pass);
        return this.http.put<Product>(this.url + 'validate?id='+product.id,product,{
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + btoa(name + ':' + pass)
            })
        }); 
    }
}

import {Injectable,Inject} from '@angular/core';
import {Transaction} from './app.transaction';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';




@Injectable({providedIn:'root'})
export class TransactionService{
    constructor(private http: HttpClient){};
   
    url:string='https://localhost:8443/api/transaction/';

    public getTransaction(name:string, pass:string){
        console.log(name+' | '+pass);
        return this.http.get<string[]>(this.url+'?name='+name,{
            headers: new HttpHeaders({
                'Content-Type':'application/json',
                'Authorization': 'Basic '+ btoa(name+':'+pass)
            })
        });
    }

}
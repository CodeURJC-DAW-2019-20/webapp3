import {Injectable,Inject} from '@angular/core';
import {Suggestion} from './app.suggestion';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { LiteralMapEntry } from '@angular/compiler/src/output/output_ast';
import {Observable} from 'rxjs';
import { map } from 'rxjs/operators';



@Injectable({providedIn:'root'})
export class SuggestionService{
    constructor(private http: HttpClient){};
    url:string='https://localhost:8443/api/suggestion/';
   


    public getPreStock(name:string, pass:string){
        return this.http.get<Suggestion[]>(this.url,{
            headers: new HttpHeaders({
                'Content-Type':'application/json',
                'Authorization': 'Basic '+ btoa(name+':'+pass)
            })
        });
    }


}
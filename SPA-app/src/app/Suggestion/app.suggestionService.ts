import {Injectable, Inject} from '@angular/core';
import {Suggestion} from './app.suggestion';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import {SuggestionPage} from './app.suggestionPage';
import { LiteralMapEntry } from '@angular/compiler/src/output/output_ast';
import {Observable} from 'rxjs';
import { map } from 'rxjs/operators';
import {Product} from '../Product/app.product';
import {AppInfomailComponent} from '../Infomail/app.infomailComponent';



@Injectable({providedIn: 'root'})
export class SuggestionService{
    constructor(private http: HttpClient){}
    url = '/api/suggestion/';



    public getSuggestionList(name: string, pass: string){
        return this.http.get<Suggestion[]>(this.url, {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + btoa(name + ':' + pass)
            })
        });
    }

    public getSuggestionPage(page:number,size:number,name: string, pass: string){
        return this.http.get<SuggestionPage>(this.url+'page?page='+page+'&size='+size, {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + btoa(name + ':' + pass)
            })
        });
    }

    public registerInfo(infomail: Suggestion){
        return this.http.post<Suggestion[]>(this.url + 'register', infomail, {
            headers: new HttpHeaders({
              'Content-Type': 'application/json'
             })
        });
    }

    public deleteSuggestion(id:string, name:string, pass:string){
        console.log(id);
        return this.http.delete(this.url+'name?name='+id,{
            headers: new HttpHeaders({
                'Content-Type':'application/json',
                'Authorization': 'Basic '+ btoa(name+':'+pass)
            })
        });
    }

}

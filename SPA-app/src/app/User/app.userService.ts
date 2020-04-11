import {Injectable,Inject} from '@angular/core';
import {User} from './app.user';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { LiteralMapEntry } from '@angular/compiler/src/output/output_ast';


@Injectable({providedIn:'root'})
export class UserService{
    constructor(private http: HttpClient){};
    
   
    registerUser(user:User){ 
       return this.http.post<User>('https://localhost:8443/api/user/register',user,{
                headers: new HttpHeaders({
                    'Content-Type':'application/json'
                })
        });
    }

   
}
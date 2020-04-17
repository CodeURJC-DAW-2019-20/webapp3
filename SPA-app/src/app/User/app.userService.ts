import {Injectable,Inject} from '@angular/core';
import {User} from './app.user';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { LiteralMapEntry } from '@angular/compiler/src/output/output_ast';
import {Observable} from 'rxjs';
import { map } from 'rxjs/operators';



@Injectable({providedIn:'root'})
export class UserService{
    constructor(private http: HttpClient){};
    url:string = 'https://localhost:8443/api/user/';


    public registerUser(user:User){
       return this.http.post<User>(this.url + 'register', user,{
                headers: new HttpHeaders({
                    'Content-Type':'application/json'
                })
        });
    }

    public getUserByName(name:string, pass:string){
        return this.http.get<User>(this.url+'?name='+name,{
            headers: new HttpHeaders({
                'Content-Type':'application/json',
                'Authorization': 'Basic '+ btoa(name+':'+pass)
            })
        });
    }

    public getAllUser(name:string, pass:string){
        return this.http.get<User[]>(this.url+'all',{
            headers: new HttpHeaders({
                'Content-Type':'application/json',
                'Authorization': 'Basic '+ btoa(name+':'+pass)
            })
        });
    }


    public updateUser(user: User){
        return this.http.put<User>(this.url+'update',user,{
            headers: new HttpHeaders({
                'Content-Type':'application/json',
                'Authorization': 'Basic '+ btoa(user.getName()+':'+user.getPass())
            })
        });
    }


/*
    logIn(name:string, pass:string){
        return this.http.get<User>('https://localhost:8443/api/logIn',{
            headers: new HttpHeaders({
                'Content-Type':'application/json',
                'Authorization': 'Basic '+ btoa(name+':'+pass)
            })
        });
    }
*/

}

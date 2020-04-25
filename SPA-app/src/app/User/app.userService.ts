import {Injectable, Inject} from '@angular/core';
import {User} from './app.user';
import {UserPage} from './app.userPage';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';




@Injectable({providedIn: 'root'})
export class UserService{
    constructor(private http: HttpClient){};
    url: string = '/api/user/';


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

     public getUserPage(page:number,size:number,name:string, pass:string){
        return this.http.get<UserPage>(this.url+'all/page?page='+page+'&size='+size,{
            headers: new HttpHeaders({
                'Content-Type':'application/json',
                'Authorization': 'Basic '+ btoa(name+':'+pass)
            })
        });
    }


     public updateUser(user: User ,name:string, pass:string){
        console.log(user)
        return this.http.put<User>(this.url+'update',user,{
            headers: new HttpHeaders({
                'Content-Type':'application/json',
                'Authorization': 'Basic '+ btoa(name+':'+pass)
            })
        });
    }

     public deleteUser(userName:string, name:string, pass:string){
        return this.http.delete(this.url+'update?name='+ userName,{
            headers: new HttpHeaders({
                'Content-Type':'application/json',
                'Authorization': 'Basic '+ btoa(name+':'+pass)
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

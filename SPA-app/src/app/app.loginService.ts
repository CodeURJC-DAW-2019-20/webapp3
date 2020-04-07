import {Injectable} from '@angular/core';
import {Http, JsonpModule} from '@angular/http';
import {User} from './app.user';


@Injectable()
export class LoginService{
    constructor(private http: Http){};

    registerUser(user:User){
        let url= 'https://localhost:8443/api/user/register';
        return this.http.post(url,user).subscribe(
            response => alert('Usuario Registrado, Verifique la cuentra via mail para acceder a su usuario'),
            error=>alert('No se ha podido crear el Usuario')
        )
    }
}
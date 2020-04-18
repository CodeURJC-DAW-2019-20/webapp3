import {Injectable,Inject} from '@angular/core';
import {User} from '../User/app.user';



@Injectable({providedIn: 'root'})
export class DataService{
 user: User = new User('Usuario','Contraseña','apellido','email','direccion','ciudad','pais','c.d.','Telefono');
}

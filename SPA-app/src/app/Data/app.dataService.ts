import {Injectable, Inject} from '@angular/core';
import {User} from '../User/app.user';
import { Product } from '../Product/app.product';



@Injectable({providedIn: 'root'})
export class DataService{
 user: User = new User('Usuario', 'Contraseña', 'apellido', 'email', 'direccion', 'ciudad', 'pais', 'c.d.', 'Telefono');
 product: Product = new Product('name', 'color','category','brand','size','description','detail');

}

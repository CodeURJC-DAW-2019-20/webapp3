import { Routes, RouterModule } from '@angular/router';
import {AppIndexComponent} from './Index/app.indexComponent';
import {LoginComponent} from './Login/app.loginComponent';
import {ProfileComponent} from './Profile/app.profileComponent';
import {AppErrorComponent} from './Error/app.errorComponent';


const routes = [
  {path: '', component: AppIndexComponent},
  {path: 'login', component: LoginComponent},
  {path: 'profile', component: ProfileComponent},
  {path: '**', component: AppErrorComponent}
];

export const routing = RouterModule.forRoot(routes);


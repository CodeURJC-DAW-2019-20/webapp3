import { Routes, RouterModule } from '@angular/router';
import {AppIndexComponent} from './Index/app.indexComponent';
import {LoginComponent} from './Login/app.loginComponent';
import {ProfileComponent} from './Profile/app.profileComponent';
import {AppErrorComponent} from './Error/app.errorComponent';
import {AppStoreComponent} from './Store/app.storeComponent';
import {AppInfomailComponent} from './Infomail/app.infomailComponent';


const routes = [
  {path: '', component: AppIndexComponent},
  {path: 'login', component: LoginComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'store', component: AppStoreComponent},
  {path: 'infomail', component: AppInfomailComponent},
  {path: '**', component: AppErrorComponent}
];

export const routing = RouterModule.forRoot(routes);


import { Routes, RouterModule } from '@angular/router';
import {AppIndexComponent} from './Index/app.indexComponent';
import {LoginComponent} from './Login/app.loginComponent';
import {ProfileComponent} from './Profile/app.profileComponent';
import {AppErrorComponent} from './Error/app.errorComponent';
import {AppStoreComponent} from './Store/app.storeComponent';
import {AppInfomailComponent} from './Infomail/app.infomailComponent';
import {AppLikeItComponent} from './LikeIt/app.likeItComponent';
import {AppBasketComponent} from './Basket/app.basketComponent';
import {AppProductComponent} from './Product/app.productComponent';
import {AppCheckoutComponent} from './Checkout/app.checkoutComponent';



const routes = [
  {path: '', component: AppIndexComponent},
  {path: 'login', component: LoginComponent},
  {path: 'login/profile', component: ProfileComponent},
  {path: 'store', component: AppStoreComponent},
  {path: 'store/product', component: AppProductComponent},
  {path: 'likeit', component: AppLikeItComponent},
  {path: 'basket', component: AppBasketComponent},
  {path: 'basket/checkout', component: AppCheckoutComponent},
  {path: 'basket/product', component: AppProductComponent},
  {path: 'product', component: AppProductComponent},
  {path: 'infomail', component: AppInfomailComponent},
  {path: '**', component: AppErrorComponent}
];

export const routing = RouterModule.forRoot(routes);


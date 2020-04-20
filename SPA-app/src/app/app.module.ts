import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {routing} from './app-routing.module';
import { LoginComponent } from './Login/app.loginComponent';
import { ProfileComponent } from './Profile/app.profileComponent';
import { UserService} from './User/app.userService';
import { ProductService} from './Product/app.productService';
import { SuggestionService } from './Suggestion/app.suggestionService';
import {DataService} from './Data/app.dataService';
import {AppHeaderComponent} from './Header/app.headerComponent';
import {AppFooterComponent} from './Footer/app.footerComponent';
import {AppIndexComponent} from './Index/app.indexComponent';
import {AppNavComponent} from './Nav/app.navComponent';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import {AppErrorComponent} from './Error/app.errorComponent';
import {AppStoreComponent} from './Store/app.storeComponent';
import {AppInfomailComponent} from './Infomail/app.infomailComponent';
import {AppLikeItComponent} from './LikeIt/app.likeItComponent';
import {AppBasketComponent} from './Basket/app.basketComponent';
import {AppProductComponent} from './Product/app.productComponent';
import {AppCheckoutComponent} from './Checkout/app.checkoutComponent';

@NgModule({
  declarations: [
    AppHeaderComponent,
    AppNavComponent,
    AppIndexComponent,
    AppStoreComponent,
    AppInfomailComponent,
    AppLikeItComponent,
    AppBasketComponent,
    LoginComponent,
    ProfileComponent,
    AppFooterComponent,
    AppErrorComponent,
    AppInfomailComponent,
    AppProductComponent,
    AppCheckoutComponent,
  ],
  imports: [
    BrowserModule,
    routing,
    NgbModule,
    FormsModule,
    HttpClientModule,
    NoopAnimationsModule
  ],
  providers: [UserService, ProductService, DataService, SuggestionService],
  bootstrap: [AppHeaderComponent, AppNavComponent, AppFooterComponent],
})
export class AppModule { }

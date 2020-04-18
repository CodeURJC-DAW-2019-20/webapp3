import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './Login/app.loginComponent';
import { ProfileComponent } from './Profile/app.profileComponent';
import { UserService} from './User/app.userService';
import { ProductService} from './Product/app.productService';
import {DataService} from './Data/app.dataService';
import {AppHeaderComponent} from './Header/app.headerComponent';
import {AppFooterComponent} from './Footer/app.footerComponent';
import {AppIndexComponent} from './Index/app.indexComponent';
import {AppNavComponent} from './Nav/app.navComponent';



@NgModule({
  declarations: [
    AppHeaderComponent,
    AppNavComponent,
    AppIndexComponent,
    LoginComponent,
    ProfileComponent,
    AppFooterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [UserService, ProductService, DataService],
  bootstrap: [AppHeaderComponent, AppNavComponent, AppIndexComponent, LoginComponent, ProfileComponent, AppFooterComponent]
})
export class AppModule { }

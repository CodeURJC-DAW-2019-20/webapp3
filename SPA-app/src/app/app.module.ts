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
import { SuggestionService } from './Suggestion/app.suggestionService';
import {DataService} from './Data/app.dataService';
import {AppHeaderComponent} from './Header/app.headerComponent';
import {AppFooterComponent} from './Footer/app.footerComponent';
import {AppIndexComponent} from './Index/app.indexComponent';
import {AppNavComponent} from './Nav/app.navComponent';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';



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
    HttpClientModule,
    NoopAnimationsModule
  ],
  providers: [UserService, ProductService, DataService,SuggestionService],
  bootstrap: [AppHeaderComponent,LoginComponent ,AppNavComponent, ProfileComponent,AppIndexComponent, AppFooterComponent]
})
export class AppModule { }

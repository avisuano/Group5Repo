import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { ForumComponent } from './forum/forum.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { SearchComponent } from './search/search.component';
import { UpdateAccountComponent } from './update-account/update-account.component';
import { VetdecComponent } from './vetdec/vetdec.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { ForumpostComponent } from './forumpost/forumpost.component';
import { HttpClientModule } from '@angular/common/http';
import { NewforumpostComponent } from './newforumpost/newforumpost.component';
import { AgmCoreModule } from '@agm/core';
import { DashboardComponent } from './dashboard/dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    NavbarComponent,
    LoginComponent,
    ForumComponent,
    CreateAccountComponent,
    SearchComponent,
    UpdateAccountComponent,
    VetdecComponent,
    AboutComponent,
    ContactComponent,
    ForumpostComponent,
    NewforumpostComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBERe0UJKwjez5wZByGBUoEAQx0cy67vEk'
    })
  ],
  providers: [],
  bootstrap: [AppComponent, HomeComponent]
})
export class AppModule { }

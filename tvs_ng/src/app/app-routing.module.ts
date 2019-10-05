import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { SearchComponent } from './search/search.component';


const routes: Routes = 
[
  {
    path: "login",
    component: LoginComponent
  },
  {
    path: "home",
    component: HomeComponent
  },
  {
    path: "create_account",
    component: CreateAccountComponent
  },
  {
    path: "search",
    component: SearchComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

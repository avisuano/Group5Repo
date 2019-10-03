import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
<<<<<<< HEAD
import { SearchComponent } from './search/search.component';
=======
import { LoginComponent } from './login/login.component';
>>>>>>> master
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  {
<<<<<<< HEAD
    path: "search", 
    component: SearchComponent
  },
  {
    path: "home",
    component: HomeComponent
  }

=======
    path: "home",
    component: HomeComponent
  },
  {
    path: "login",
    component: LoginComponent
  }
>>>>>>> master
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

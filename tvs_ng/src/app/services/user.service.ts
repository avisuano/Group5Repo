import { Injectable } from '@angular/core';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { User} from '../classes/User';

@Injectable({
  providedIn: 'root'
})
export class UserService 
{
  constructor(private http:HttpClient) { }

  userLogin(user:User){
    let headers = new HttpHeaders().set("Content-Type", "application/x-www-form-urlencoded");

    let body = new HttpParams().set("username", user.username.toString()).set("password", user.password.toString());
    return this.http.post("http://localhost:8080/SpringMVC/user/login", {headers: headers});
  }
}

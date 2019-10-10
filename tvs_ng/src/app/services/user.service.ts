import { Injectable } from '@angular/core';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { User} from '../classes/User';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService 
{
  constructor(private http:HttpClient) { }

  userLogin(user:string, password:string){
    let headers = new HttpHeaders().set("Content-Type", "application/json");

   // let body = new HttpParams().set("username", JSON.stringify(user)).set("password", JSON.stringify(password));
    return this.http.post("http://localhost:8080/SpringMVC/user/login", JSON.stringify({"user":user, "password":password}), {headers:headers});
  }

  getAllUsers():Observable<User[]>{
    return this.http.get("http://localhost:8080/SpringMVC/user/all") as Observable<User[]>;
  }
}

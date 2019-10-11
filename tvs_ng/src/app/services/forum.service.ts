import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Forum } from '../classes/forum';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ForumService {

  constructor(private http:HttpClient) { }

  getAllForums():Observable<Forum[]>{
    return this.http.get("http://localhost:8080/SpringMVC/forum/all") as Observable<Forum[]>;
  }

  submitForum(forum:Forum){
    let headers = new HttpHeaders().set("Content-Type", "application/json");
    console.log("Before Request" + JSON.stringify(forum));

    return this.http.post("http://localhost:8080/SpringMVC/forum/insert",JSON.stringify(forum), {headers: headers});
  }
}

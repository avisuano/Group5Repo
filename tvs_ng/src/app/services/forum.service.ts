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
    let headers = new HttpHeaders().set("Content-Type", "application/x-www-form-urlencoded");

    let body = new HttpParams().set("forum_id", forum.forum_id.toString()).set("title", forum.title).set("body", forum.body.toString()).set("isOffensive", forum.isOffensive.toString()).set("replies", forum.replies.toString()).set("user_id", forum.user_id.toString());

    //Now let's hit our endpoing, attaching our body and headers.
    return this.http.post("http://localhost:8080/SpringMVC/forum/insert", {headers: headers});
  } 
}

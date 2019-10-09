import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Forum } from '../classes/forum';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ForumService {

  
  /**
   * In order to use dependency injection with Angular, we must include a private HttpClient parameter in this constructor.
   */
  constructor(private http:HttpClient) { }

  getAllForums():Observable<Forum[]>{
    return this.http.get("http://localhost:8080/SpringMVC/forum/all") as Observable<Forum[]>;
  }

  /**
   * When making a post request in Angular, you must construct the header and the body yourself.
   */
  submitForum(forum:Forum){
    // Setting the header. This content type signifies that we're sending form data.
    let headers = new HttpHeaders().set("Content-Type", "application/x-www-form-urlencoded");

    // Constructing our body by adding our parameters. 
    // Notice that we are specifying the name by which we must grab each parameter
    // using the getParameter() method provided by the Servlet API.
    let body = new HttpParams().set("forum_id", forum.forum_id.toString()).set("title", forum.title).set("body", forum.body.toString()).set("isOffensive", forum.isOffensive.toString()).set("replies", forum.replies.toString()).set("user_id", forum.user_id.toString());

    //Now let's hit our endpoing, attaching our body and headers.
    return this.http.post("http://localhost:8080/SpringMVC/forum/insert", {headers: headers});
  }

  
}

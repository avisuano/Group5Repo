import { Component, OnInit } from '@angular/core';
import { ForumService } from '../services/forum.service';
import { Forum } from '../classes/forum';
import { Router } from "@angular/router";

@Component({
  selector: 'app-newforumpost',
  templateUrl: './newforumpost.component.html',
  styleUrls: ['./newforumpost.component.css']
})
export class NewforumpostComponent implements OnInit {

  title:string;
  body:string;
  user_id:number;

  constructor(private fs:ForumService, private router: Router) { }

  ngOnInit() {
  }

  data:Forum[] = [];

  submitForum(){
    
    let newForum:Forum;

    let title = (<HTMLInputElement>document.getElementById("title")).value
    let body = (<HTMLInputElement>document.getElementById("body")).value
    let user_id:number = parseFloat((<HTMLInputElement>document.getElementById("user_id")).value)

    newForum = new Forum(0, title, body, false, 0, user_id);

    this.fs.submitForum(newForum).subscribe(
      data => {
        this.router.navigate(['/forum']);
      },
      error => {

      }
      );
    }

}

import { Component, OnInit } from '@angular/core';
import { ForumService } from '../services/forum.service';
import { Forum } from '../classes/forum';

@Component({
  selector: 'app-newforumpost',
  templateUrl: './newforumpost.component.html',
  styleUrls: ['./newforumpost.component.css']
})
export class NewforumpostComponent implements OnInit {

  constructor(private fs:ForumService) { }

  ngOnInit() {
  }

  data:Forum[] = [];

  submitForum(forum:Forum){
    //Note that we still have to subscribe even if we're doing a post request. If we don't, we will not get our response.
    this.fs.submitForum(forum).subscribe(
      data => {

      },
      error => {

      }
    );
  }

}

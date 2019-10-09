import { Component, OnInit } from '@angular/core';
import { ForumService } from '../services/forum.service';
import { Forum } from '../classes/forum';

@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {

  constructor(private fs:ForumService) { }

  ngOnInit() {
    this.getAllForums();
  }

  data:Forum[] = [];

  getAllForums(){
    this.fs.getAllForums().subscribe(

      data => {
        this.data = data;
        console.log(this.data);
      },
      error => {
        error = "Sorry, Couldn't load the newest forums!"
        console.log(error);
      }

    )
  }

}

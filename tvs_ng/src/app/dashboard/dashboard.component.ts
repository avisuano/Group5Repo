import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../classes/user';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private us:UserService) { }

  ngOnInit() {
    this.getAllUsers();
  }

  data:User[] = [];

  username:string = "username";

  getAllUsers(){
    this.us.getAllUsers().subscribe(

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

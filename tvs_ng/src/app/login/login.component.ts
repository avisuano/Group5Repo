import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../classes/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit 
{
  constructor(private usr:UserService) { }
  ngOnInit() 
  {
  }

  data:User[] = [];
  
  userLogin()
  {
    this.usr.getAllUsers().subscribe(

      data => {
        this.data = data;
        console.log(this.data);
      },
      error => {
        error = "Sorry, Couldn't load the newest forums!"
        console.log(error);
      }

    )
    console.log("we made it!")
    let username = (<HTMLInputElement>document.getElementById("username")).value;
    let password = (<HTMLInputElement>document.getElementById("password")).value;

    console.log(username + " " + password)
    this.usr.userLogin(username,password);

  }

}

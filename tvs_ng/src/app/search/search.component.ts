import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Form } from '@angular/forms';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  private address: ''

  getAdr(string: any) {
    let adr = this.address
    let addressUrl = adr.split(' ').join('+')
    let qurl = 'https://maps.googleapis.com/maps/api/geocode/json?address=' + addressUrl + '&key=AIzaSyBERe0UJKwjez5wZByGBUoEAQx0cy67vEk'
    console.log(qurl)
  }
}

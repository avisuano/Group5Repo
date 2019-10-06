import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

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
    let result = this.getGeo(addressUrl)
    console.log(result)
  }

  getGeo(url){
    let qurl = 'https://maps.googleapis.com/maps/api/geocode/json?address=' + url + '&key=AIzaSyBERe0UJKwjez5wZByGBUoEAQx0cy67vEk'
    let add = this.http.get(qurl) as Observable<FormData>
    console.log(add)
  }
}

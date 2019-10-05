import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms'; 

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  private apiKey = 'AIzaSyBERe0UJKwjez5wZByGBUoEAQx0cy67vEk'
  address: string = ''

  getAdr(){
    let adr = this.address
    let addressUrl = adr.split(' ').join('+')
    let url = 'https://maps.googleapis.com/maps/api/geocode/json?address=' + addressUrl + '&key=' + this.apiKey

    
  }
}

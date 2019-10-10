import { Component, OnInit, NgZone } from '@angular/core';
import { SearchService } from '../services/search.service';

declare var google: any

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  private address: ''
  public lat = 44.8484524
  public lng = -123.23398880000002

  constructor(private ss: SearchService, private _zone: NgZone) {
  }

  ngOnInit() {
  }

  getAdr(address: string) {

    let x = document.getElementById('map');
    x.style.display = "none";

    // Well geo coder kind of works
    let geocoder = new google.maps.Geocoder()
    geocoder.geocode({ 'address': this.address }, function (results) {
      this.lat = results[0].geometry.location.lat()
      this.lng = results[0].geometry.location.lng()
      console.log('Inside the function ' + this.lat + ', ' + this.lng)
    })
    console.log('After the function ' + this.lat + ', ' + this.lng)

    // Remove the whitespace and replace with +'s
    let url = this.address.split(' ').join('+')
    // Build the complete url to send to Google Geocode to get the latitude and longitude
    let qurl = 'https://maps.googleapis.com/maps/api/geocode/json?address=' + url + '&key=AIzaSyBERe0UJKwjez5wZByGBUoEAQx0cy67vEk'
    // Can I get an api call?
    this.ss.getAdr(qurl).subscribe(data => { console.log(data) })

    // Get the div container to allow it to be displayed

    x.style.display = "block";
  }
}
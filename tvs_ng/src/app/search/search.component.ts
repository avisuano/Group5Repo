import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AgmCoreModule } from '@agm/core';
import { Observable } from 'rxjs/internal/Observable';

declare var google: any

interface LatLng {
  lat: number
  lng: number
}

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})

export class SearchComponent implements OnInit {

  private address: ''
  private lat = 32.735687;
  private lng = -97.10806559999997;

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }


  getAdr(address: string) {

    let geocoder = new google.maps.Geocoder()
    geocoder.geocode({ 'address': this.address }, function (results) {
      this.lat = results[0].geometry.location.lat()
      this.lng = results[0].geometry.location.lng()
      console.log('Inside the function ' + this.lat + ', ' + this.lng)
    })
    console.log('After the function ' + this.lat + ', ' + this.lng)

    // Remove the whitespace and replace with +'s
    let url = address.split(' ').join('+')
    // Build the complete url to send to GeoCode to get the latitude and longitude
    let qurl = 'https://maps.googleapis.com/maps/api/geocode/json?address=' + url + '&key=AIzaSyBERe0UJKwjez5wZByGBUoEAQx0cy67vEk'
    console.log(qurl)

    // Un-hide the map
    var x = document.getElementById("map");
    x.style.display = "block";
  }
}

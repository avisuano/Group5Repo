import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AgmCoreModule } from '@agm/core';
import { Observable } from 'rxjs/internal/Observable';

interface LatLng{
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
  private lat = 44.9428975;
  private lng = -123.0350963;

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }


  getAdr(address: string) {
    // Un-hide the map
    var x = document.getElementById("map");
    x.style.display = "block";

    // Remove the whitespace and replace with +'s
    let url = address.split(' ').join('+')
    // Build the complete url to send to GeoCode to get the latitude and longitude
    let qurl = 'https://maps.googleapis.com/maps/api/geocode/json?address=' + url + '&key=AIzaSyBERe0UJKwjez5wZByGBUoEAQx0cy67vEk'

    console.log(qurl)
  }
}

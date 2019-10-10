import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AgmCoreModule, MapsAPILoader } from '@agm/core';
import { Observable } from 'rxjs/internal/Observable';

declare var google: any

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  geocoder: any
  private address: ''
  private lat = 44.9428975;
  private lng = -123.0350963;

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
  }


  getAdr(address: string) {
    // Trying to make sure the values change
    console.log("Longitude after address search " + this.lat)
    console.log("Latitude after address search " + this.lng)

    // Remove the whitespace and replace with +'s
    let url = address.split(' ').join('+')
    // Build the complete url to send to Google Geocode to get the latitude and longitude
    let qurl = 'https://maps.googleapis.com/maps/api/geocode/json?address=' + url + '&key=AIzaSyBERe0UJKwjez5wZByGBUoEAQx0cy67vEk'
    // Does the URL send me where it's supposed to?
    console.log(qurl)
    this.http.get(qurl).subscribe(data => {
      // Did I get the right JSON result from the API call?
      console.log(data)
    })

    // Display the map
    var x = document.getElementById("map");
    x.style.display = "block";
  }
}

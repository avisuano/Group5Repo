import { Component, OnInit } from '@angular/core';
import { SearchService } from '../services/search.service';
import { google } from '@agm/core/services/google-maps-types';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  private address: ''
  private lat = 44.9428975;
  private lng = -123.0350963;

  constructor(private ss:SearchService) {
  }

  ngOnInit() {
    this.getAdr(this.address)
  }

  getAdr(address: string) {
    // Remove the whitespace and replace with +'s
    let url = this.address.split(' ').join('+')
    // Build the complete url to send to Google Geocode to get the latitude and longitude
    let qurl = 'https://maps.googleapis.com/maps/api/geocode/json?address=' + url + '&key=AIzaSyBERe0UJKwjez5wZByGBUoEAQx0cy67vEk'
    // Can I get an api call?
    this.ss.getAdr(qurl).subscribe( data => { 
      console.log(data)
    })

    let geocoder = new google.maps.Geocoder()
    geocoder.geocde({'address' : this.address}, function(results, status){
      if(status === google.maps.GeocoderStatus.OK){
        this.lat = results[0].geometry.location.lat()
        this.lng = results[0].geometry.location.lng()
        console.log(this.lat + ', ' + this.lng)
      }
    })

    // Display the map
    var x = document.getElementById("map");
    x.style.display = "block";
  }
}

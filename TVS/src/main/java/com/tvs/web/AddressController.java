package com.tvs.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvs.model.Address;

@CrossOrigin

@RestController

//This maps this entire controller to "/address"
@RequestMapping(value="/address")
public class AddressController {

	private String url = "https://maps.googleapis.com/maps/api/geocode/json?address=Salem,+OR&key=AIzaSyBERe0UJKwjez5wZByGBUoEAQx0cy67vEk";
	
	@GetMapping(value="/geo")
	public Address getAdr(){
		return Rest.getAddress(url);
	}
}

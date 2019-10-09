package com.tvs.web;

import org.springframework.web.client.RestTemplate;

import com.tvs.model.Address;

public class Rest {

	public static Address getAddress(String url) {
		RestTemplate rest = new RestTemplate();
		Address getAddress = rest.getForObject(url, Address.class);
	    return getAddress;
	}
//	public static Joke getChuckJoke() {
//		RestTemplate restTemplate = new RestTemplate();
//		Joke retrievedJoke = restTemplate.getForObject("http://api.icndb.com/jokes/random/", Joke.class);
//		return retrievedJoke;
//	}
	
}

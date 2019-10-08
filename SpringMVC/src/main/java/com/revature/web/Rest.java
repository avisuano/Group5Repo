package com.revature.web;

import org.springframework.web.client.RestTemplate;

import com.revature.model.Joke;

public class Rest {

	/*
	 * The RestTemplate class is build into Spring Web. It provides a way of accession
	 * data from a third-party API's and immediately putting it into a Java object.
	 * This is how you consume REST with Spring
	 */
	public static Joke getChuckJoke() {
		RestTemplate restTemplate = new RestTemplate();
		Joke retrievedJoke = restTemplate.getForObject("http://api.icndb.com/jokes/random/", Joke.class);
		return retrievedJoke;
	}
}

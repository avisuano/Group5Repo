package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exception.NonExistentMovieException;
import com.revature.model.Joke;
import com.revature.model.Movie;
import com.revature.service.MovieService;

/*
 * Java backend will be hosted somewhere where the origin (e.g. the protocol, host, and port)
 * are different from your Angular frontend, you will have issues with the CORS (Cross-Origin Resource Sharing).
 * In order to fix this, Spring has the @CrossOrigin annotation to remedy this. By default, it allows
 * all origins. You can set a specific value which will point to a specific origin.
 * @CrossOrigin(value="exactURLHere")
 */
@CrossOrigin
// Spring stereotype, that identifies this Spring Bean as a controller
//@Controller
/*
 * Using a generic controller, does not automatically write to the response body.
 * We instead want to use a RestController will always write to the response
 * body rather than attempting to return a view. The @ResContontroller is just a 
 * convenience annotation that is a combo of @Controller and @ResponseBody
 */
@RestController
@RequestMapping(value="/movie")
public class MovieController {

	private MovieService movieService;
	
	@Autowired
	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}
	
	// We will be using a front end framework, so we won't be using this.
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHome() {
		return "index";
	}
	
	/*
	 * Handler that will handle each NonExistentMovieException that is thrown
	 */
	@ExceptionHandler(NonExistentMovieException.class)
	public String error() {
		return "This would have returned a 404 page if it was a generic controller.";
	}
	
	// A more specific RequestMapping this has the HTTP methods built in. 
	// Produces attribute specifies what is sent back to the client.
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	// Write to the response body
	@ResponseBody
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}
	
	// This method accepts Post requests. @RequestBody to grab the movie object directly from the request body.
	// Spring does this with Jackson Databind to marshall the JSON in the request body into a movie object.
	@PostMapping(value="/insert")
	public void insertMovie(@RequestBody Movie m) {
		movieService.insertMovie(m);
	}
	
	/*
	 * When you want to retrieve a value and sent it back to the client, there are two useful ways:
	 * using the @PathVariable annotation
	 * using the @RequestParam annotation
	 */
	@GetMapping(value="/{id}")
	public Movie getById(@PathVariable int id){
		return movieService.getMovieById(id);
	}
	// @RequestParam grabs the parameter from the query string
	@GetMapping(value="/byId")
	public Movie getMovieById(@RequestParam int id) {
		return movieService.getMovieById(id);
	}
	
	/*
	 * Spring web has a special object, "ResponseEntity". It allows you to send a representation of our data and code
	 */
	@GetMapping(value="/byMovieId")
	public ResponseEntity<Movie> getMovieWithResponseEntity(@RequestParam int id) {
		if(id > 1)
		return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.OK);
		
		else throw new NonExistentMovieException();
	}
	
	@GetMapping(value="/joke")
	public Joke getRandomJoke() {
		return Rest.getChuckJoke();
	}
}

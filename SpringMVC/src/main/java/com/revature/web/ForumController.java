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
import com.revature.model.Forum;
import com.revature.service.ForumService;

@CrossOrigin

@RestController

//This maps this entire controller to "/forum"
@RequestMapping(value="/forum")
public class ForumController {

	@Autowired
	private ForumService forumService;
	
	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
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
	
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Forum> getAllForums(){
		return forumService.getAllForums();
	}
	
	/*
	 * The PostMapping annotation denotes that this method accepts post requests.
	 */
	@PostMapping(value="/insert")
	public void insertMovie(@RequestBody Forum f) {
		forumService.insertForum(f);
	}
	
	/*
	 * When we want to retrieve a value and send it back to the client, 
	 * there are two useful ways of doing so:
	 * Using the @PathVariable annotation
	 * Using the @RequestParam annotation
	 * 
	 * Let's first play around with the PathVariable annotation. In order to use it,
	 * we must place our path variable inside of {} brackets.
	 */
	@GetMapping(value="/{id}")
	public Forum getForumById(@PathVariable int id) {
		return forumService.getForumById(id);
	}
	
	@GetMapping(value="/byId")
	public Forum getForumByIdAgain(@RequestParam int id) {
		return forumService.getForumById(id);
	}
	
	@GetMapping(value="/byForumId")
	public ResponseEntity<Forum> getMovieWithResponseEntity(@RequestParam int id) {
		return new ResponseEntity<>(forumService.getForumById(id), HttpStatus.OK);
	}
	
}

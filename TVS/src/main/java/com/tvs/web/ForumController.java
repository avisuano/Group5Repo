package com.tvs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tvs.model.Forum;
import com.tvs.service.ForumService;

public class ForumController {

@CrossOrigin

@RestController

//This maps this entire controller to "/forum"
@RequestMapping(value="/forum")

public class MovieController {
	@Autowired
	private ForumService forumService;
	
	/*
	 * Injecting the forumService into this controller. 
	 * (Using dependency injection)
	 */
	
//	public void setForumService(ForumService forumService) {
//		this.forumService = forumService;
//	}
	
	// checking if front-end would theoretically work ..but it is a useless page cause 
	// we're using angular4+
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHome() {
		return "index";
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
}

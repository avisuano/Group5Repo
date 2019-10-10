package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exception.NonExistentMovieException;
import com.revature.model.User;
import com.revature.service.UserService;

@CrossOrigin

@RestController
@RequestMapping(value="/user")
public class UserController {
private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
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
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping(value="/insert")
	public void insertUser(@RequestBody User u) {
		userService.insertUser(u);
	}
	
	@GetMapping(value="/{id}")
	public User getById(@PathVariable int id)
	{
		return userService.getUserById(id);
	}
	 @PostMapping(value="/login")
	 public User login(@RequestParam String user, @RequestParam String password)
	 {
		 System.out.println("hi "+ user +" " + password);
		 return userService.getUserByUsername(user);
	 }
	/*
	 * USER LOGIN
	 */
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	  public String init(Model model) {
//	    model.addAttribute("msg", "Please Enter Your Login Details");
//	    return "login";
//	  }
//
//	  @RequestMapping(method = RequestMethod.POST)
//	  public String submit(Model model, @ModelAttribute("Userlogin") User userLogin) {
//	    if (userLogin != null && userLogin.getUsername() != null & userLogin.getPassword() != null) {
//	      if (userLogin.getUsername().equals("username1") && userLogin.getPassword().equals("password")) {
//	        model.addAttribute("msg", userLogin.getUsername());
//	        return "success";
//	      } else {
//	        model.addAttribute("error", "Invalid Details");
//	        return "login";
//	      }
//	    } else {
//	      model.addAttribute("error", "Please enter Details");
//	      return "login";
//	    }
//	  }	
}

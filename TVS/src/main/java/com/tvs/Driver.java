package com.tvs;

import com.tvs.model.User;
import com.tvs.service.UserService;

public class Driver {
	
	public static void main(String[] args) {
		UserService us = new UserService();
		//Getting list of users
		System.out.println(us.getAllUsers()); 
		
		//Creating new user
		User newUser = new User(4, "newuser", "newuser@mail.com", "Jane", "Doe", false, 0);
		us.insertUser(newUser);
		
		System.out.println(us.getAllUsers()); 
		
		//Getting user by ID
		System.out.println(us.getUserById(2));
		
		//Getting user by name
		System.out.println(us.getUserByName("Robert"));
		
		//Updating User
		User newUserUpdate = new User(4, "Jane4321", "jane@mail.com", "Jane", "Doeth", false, 0);
		us.updateUser(newUserUpdate);
		
		//Deleting User by user name
		System.out.println(us.getAllUsers()); 
		us.deleteUser("Jane4321");
		System.out.println(us.getAllUsers()); 
		
	}
}

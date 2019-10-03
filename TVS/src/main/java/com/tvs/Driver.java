package com.tvs;

import com.tvs.model.Forum;
import com.tvs.model.User;
import com.tvs.service.ForumService;
import com.tvs.service.UserService;

public class Driver {
	
	public static void main(String[] args) {
		
		/*
		 * CALLING USER LOGIC (TO MAKE SURE IT ALL WORKS)
		 * ***********************************************
		 */
		
		UserService us = new UserService();
		//Getting list of users
//		System.out.println(us.getAllUsers()); 
//		
//		//Creating new user
//		User newUser = new User(4, "newuser", "newuser@mail.com", "Jane", "Doe", false, 0);
//		us.insertUser(newUser);
//		
//		System.out.println(us.getAllUsers()); 
//		
//		//Getting user by ID
//		System.out.println(us.getUserById(2));
//		
//		//Getting user by name
//		System.out.println(us.getUserByName("Robert"));
//		
//		//Updating User
//		User newUserUpdate = new User(4, "Jane4321", "jane@mail.com", "Jane", "Doeth", false, 0);
//		us.updateUser(newUserUpdate);
//		
//		//Deleting User by user name
//		System.out.println(us.getAllUsers()); 
//		us.deleteUser("Jane4321");
//		System.out.println(us.getAllUsers()); 
		
		/*
		 * CALLING FORUM LOGIC (TO MAKE SURE IT ALL WORKS)
		 * ***********************************************
		 */
		
		ForumService fs = new ForumService();
		System.out.println(fs.getAllForums());
		
		//Creating new forum
		Forum newForum = new Forum(6, "New Forum", "This is a new forum body", false, 0, 2);
		fs.insertForum(newForum);
		
		System.out.println(fs.getAllForums());
		
		//Getting forum by ID
		System.out.println(fs.getForumById(2));
		
		//Getting forum by title (or name..whichever you wanna call it)
		System.out.println(fs.getForumByName("What happens after the military?"));
		
		//Updating Forum
		Forum newForumUpdate = new Forum(5, "How do I convert my military skills to civilian skills?", 
				"After getting out the military I'm struggling with converting"
				+ " my military skills/experiences to a position in the civilian world.", 
				false, 0, 1);
		fs.updateForum(newForumUpdate);
		
		System.out.println(fs.getAllForums());
		
		//Deleting forum by title
		System.out.println(fs.getAllForums()); 
		fs.deleteForum("How do I convert my military skills to civilian skills?");
		System.out.println(fs.getAllForums()); 
	
	}
}

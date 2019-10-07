package com.tvs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tvs.model.Forum;
import com.tvs.model.ForumPost;
import com.tvs.model.User;
import com.tvs.service.ForumPostService;
import com.tvs.service.ForumService;
import com.tvs.service.UserService;

public class Driver {
	
	public static void main(String[] args) {
		
		//We are using an XML file that is on our class path as our application context,
		//so we want to use a ClassPathXmlApplicationContext. We can use our context
		//to grab a bean.
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//We use our context to get a bean.
		ForumService forumService = context.getBean("forumService", ForumService.class);
		
		//System.out.println(forumService.getAllForums());

		/*
		 * CALLING USER LOGIC (TO MAKE SURE IT ALL WORKS)
		 * ***********************************************
		 */
		
//		UserService us = new UserService();
//		//Getting list of users
//		System.out.println(us.getAllUsers()); 
//		
//		//Creating new user
//		User newUser = new User(4, "newuser", "newuser@mail.com", "Jane", "Doe", "South Cooper Street 1001", "United States", "TX", 75052, false, 0);
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
//		User newUserUpdate = new User(4, "Jane4321", "jane@mail.com", "Jane", "Doeth", "South Cooper Street 1001", "United States", "TX", 75052, false, 0);
//		us.updateUser(newUserUpdate);
//		
//		//Deleting User by user name
//		System.out.println(us.getAllUsers()); 
//		us.deleteUser("Jane4321");
//		System.out.println(us.getAllUsers()); 
//		
//		/*
//		 * CALLING FORUM LOGIC (TO MAKE SURE IT ALL WORKS)
//		 * ***********************************************
//		 */
//		
//		ForumService fs = new ForumService();
//		System.out.println(fs.getAllForums());
//		
//		//Creating new forum
//		Forum newForum = new Forum(6, "New Forum", "This is a new forum body", false, 0, 2);
//		fs.insertForum(newForum);
//		System.out.println(fs.getAllForums()); //looking at result of inserting new forum
//		
//		//Getting forum by ID
//		System.out.println(fs.getForumById(2));
//		
//		//Getting forum by title (or name..whichever you wanna call it)
//		System.out.println(fs.getForumByName("What happens after the military?"));
//		
//		//Updating Forum
//		Forum newForumUpdate = new Forum(5, "How do I convert my military skills to civilian skills?", 
//				"After getting out the military I'm struggling with converting"
//				+ " my military skills/experiences to a position in the civilian world.", 
//				false, 0, 1);
//		fs.updateForum(newForumUpdate);
//		System.out.println(fs.getAllForums()); //looking at result of updating forum
//		
//		//Deleting forum by title
//		System.out.println(fs.getAllForums()); //before
//		fs.deleteForum("How do I convert my military skills to civilian skills?");
//		System.out.println(fs.getAllForums()); //after
//		
//		/*
//		 * CALLING FORUM POST LOGIC (TO MAKE SURE IT ALL WORKS)
//		 * ****************************************************
//		 */
//		ForumPostService fps = new ForumPostService();
//		System.out.println(fps.getAllForumPosts());		
//		
//		//Creating new forum post
//		ForumPost newForumPost = new ForumPost(4, 3, "You can donate gear to the salvation army too.", 3, false);
//		fps.insertForumPost(newForumPost);
//		
//		System.out.println(fps.getAllForumPosts());	// looking at result of updated forum post
//		
//		//Getting forum post by ID
//		System.out.println(fps.getForumPostById(2));
//		
//		//Updating Forum Post
//		ForumPost newForumPostUpdate = new ForumPost(4, 3, "You can donate gear and supplies"
//				+ " to salvation army or good will.", 3, false);
//		fps.updateForumPost(newForumPostUpdate);
//		
//		//Getting ALL forum posts by specific user
//		System.out.println(fps.getAllForumPostsFromUserId(1));
//		
//		//Deleting forum by title
//		System.out.println(fps.getAllForumPosts()); //before
//		fps.deleteForumPost(4);
//		System.out.println(fps.getAllForumPosts()); //after
	
	}
}

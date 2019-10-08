package com.revature.service;

import java.util.List;

import com.revature.model.ForumPost;
import com.revature.respository.ForumPostRepositoryImpl;


public class ForumPostService {
	// Gets all forum posts
	public List<ForumPost> getAllForumPosts(){
		return new ForumPostRepositoryImpl().getAllForumPosts();
	}
	
	// Inserts a new forum posts
	public void insertForumPost(ForumPost fp) {
		new ForumPostRepositoryImpl().insertForumPost(fp);
	}
	
	// Get by forum post id (forumpost_id)
	public ForumPost getForumPostById(int id) {
		return new ForumPostRepositoryImpl().getForumPostById(id);
	}
	
	// Get all forum posts by user's id
	public List<ForumPost> getAllForumPostsFromUserId(int user_id) {
		return new ForumPostRepositoryImpl().getAllForumPostsFromUserId(user_id);
	}
	
	// Update forum post information
	public void updateForumPost(ForumPost fp) {
		new ForumPostRepositoryImpl().updateForumPost(fp);
	}
	
	// Delete forum post by id (forumpost_id)
	public void deleteForumPost(int id) {
		new ForumPostRepositoryImpl().deleteForumPost(id);
	}
}

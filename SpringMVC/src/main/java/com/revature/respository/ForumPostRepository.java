package com.revature.respository;

import java.util.List;

import com.revature.model.ForumPost;

public interface ForumPostRepository {
	public List<ForumPost> getAllForumPosts(); // Get all forum posts
	void insertForumPost(ForumPost fp); // Insert new forum post
	ForumPost getForumPostById(int id); // Get forum post by ID
	public List<ForumPost> getAllForumPostsFromUserId(int user_id); // Get all forum posts from user by id
	void updateForumPost(ForumPost fp); // Update forum post information
	void deleteForumPost(int id); // Delete forum post by title
}

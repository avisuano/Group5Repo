package com.revature.respository;

import java.util.List;
import com.revature.model.Forum;

public interface ForumRepository {
	public List<Forum> getAllForums(); // Get all forums
	void insertForum(Forum f); // Insert new forum
	Forum getForumById(int id); // Get forum by ID
	Forum getForumByName(String title); // Get forum by title
	void updateForum(Forum f); // Update forum information
	void deleteForum(String title); // Delete forum by title
}

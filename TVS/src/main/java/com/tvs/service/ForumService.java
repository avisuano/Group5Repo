package com.tvs.service;

import java.util.List;

import com.tvs.model.Forum;
import com.tvs.repository.ForumRepositoryImpl;

public class ForumService {
	// Gets all forums
	public List<Forum> getAllForums() {
		return new ForumRepositoryImpl().getAllForums();
	}

	// Inserts a new forum
	public void insertForum(Forum f) {
		new ForumRepositoryImpl().insertForum(f);
	}

	// Get by forum id
	public Forum getForumById(int id) {
		return new ForumRepositoryImpl().getForumById(id);
	}

	// Get forum by title
	public Forum getForumByName(String title) {
		return new ForumRepositoryImpl().getForumByName(title);
	}

	// Update forum information
	public void updateForum(Forum f) {
		new ForumRepositoryImpl().updateForum(f);
	}

	// Delete forum by title
	public void deleteForum(String title) {
		new ForumRepositoryImpl().deleteForum(title);
	}
}

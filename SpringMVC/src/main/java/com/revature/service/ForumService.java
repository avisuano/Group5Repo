package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Forum;
import com.revature.respository.ForumRepositoryImpl;

@Service("forumService")
public class ForumService {
	
	@Autowired
	ForumRepositoryImpl forumRepository;
//	
//	//Using constructor injection.
	
	public ForumService(ForumRepositoryImpl forumRepository) {
		this.forumRepository = forumRepository;
	}
	
	// Gets all forums
	public List<Forum> getAllForums() {
		return forumRepository.getAllForums();
	}

	// Inserts a new forum
	public void insertForum(Forum f) {
		forumRepository.insertForum(f);
	}

	// Get by forum id
	public Forum getForumById(int id) {
		return forumRepository.getForumById(id);
	}

	// Get forum by title
	public Forum getForumByName(String title) {
		return forumRepository.getForumByName(title);
	}

	// Update forum information
	public void updateForum(Forum f) {
		forumRepository.updateForum(f);
	}

	// Delete forum by title
	public void deleteForum(String title) {
		forumRepository.deleteForum(title);
	}
}

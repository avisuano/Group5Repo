package com.tvs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvs.model.Forum;
import com.tvs.repository.ForumRepository;

@Service("forumService")
public class ForumService {
	
	// Still needs work 
	@Autowired
	ForumRepository forumRepository;
//	
//	//Using constructor injection.
	
	public ForumService(ForumRepository forumRepository) {
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

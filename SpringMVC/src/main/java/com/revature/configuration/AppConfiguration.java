package com.revature.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.revature.respository.ForumRepository;
import com.revature.respository.ForumRepositoryImpl;
import com.revature.respository.UserRepository;
import com.revature.respository.UserRepositoryImpl;

// Denotes that this class should be used to generate beans and requests for those beans
@Configuration
public class AppConfiguration {

	@Bean(value="forumRepository")
	@Scope(scopeName="singleton")
	public ForumRepository getForumRepository() {
		return new ForumRepositoryImpl();
	}
	
	@Bean(value="userRepository")
	@Scope(scopeName="singleton")
	public UserRepository getUserRepository() {
		return new UserRepositoryImpl();
	}
	
	
}

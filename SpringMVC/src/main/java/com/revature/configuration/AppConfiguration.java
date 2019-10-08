package com.revature.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.revature.respository.ForumRepository;
import com.revature.respository.ForumRepositoryImpl;
import com.revature.respository.MovieRepository;
import com.revature.respository.MovieRepositoryImpl;

// Denotes that this class should be used to generate beans and requests for those beans
@Configuration
public class AppConfiguration {

	// This method returns a bean
	@Bean(value="movieRepository2")
	// Defines the scope of the bean (singleton is the default)
	@Scope(scopeName="singleton")
	public MovieRepository getMovieRepository() {
		return new MovieRepositoryImpl();
	}
	
	// This method returns a bean
	@Bean(value="forumRepository")
	// Defines the scope of the bean (singleton is the default)
	@Scope(scopeName="singleton")
	public ForumRepository getForumRepository() {
		return new ForumRepositoryImpl();
	}
}

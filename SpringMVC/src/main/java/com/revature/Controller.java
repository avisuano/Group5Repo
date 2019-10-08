package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.MovieService;

public class Controller {

	public static void main(String[] args) {
		
		/*
		 * In this layer of our application, we have a MovieService dependency.
		 * This layer of the application depends on MovieService's implementation.
		 */
		//MovieService movieService = new MovieService();
		
		/*
		 * We are using an xml file that is on our class path as our application context,
		 * so we want to use a ClassPathXmlApplicationContext. We can use our context to grab a bean.
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//We use the context to get a bean.
		MovieService movieService = context.getBean("movieService", MovieService.class);
		
		System.out.println(movieService.getAllMovies());
		System.out.println(movieService.getMovieById(1));
	}
}

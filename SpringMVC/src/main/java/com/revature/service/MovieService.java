package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Movie;
import com.revature.respository.MovieRepository;

@Service(value="movieService")
public class MovieService {

	// The MovieServer class has a MovieRepository object as a dependency.
	// This is an example of tight coupling, I would have to change this class'
	// implementation
	// if we change the MovieRepositoryImpl's implementation.

	// Don't instantiate this object, the framework will do it.
	MovieRepository movieRepository;
	//MovieRepository movieRepository2;

	// We want to use setter injection
	// public void setMovieRepository(MovieRepository movieRepository) {
	// this.movieRepository = movieRepository;
	// }
	//public MovieService() {}
	
	// This is for constructor injection.
	@Autowired
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public List<Movie> getAllMovies() {
		return movieRepository.getAllMovies();
	}

	public void insertMovie(Movie movie) {
		movieRepository.insertMovie(movie);
	}

	public Movie getMovieById(int id) {
		return movieRepository.getMovieById(id);
	}

	public Movie getMovieByName(String name) {
		return movieRepository.getMovieByName(name);
	}

	public void updateMovie(Movie movie) {
		movieRepository.updateMovie(movie);
	}
}

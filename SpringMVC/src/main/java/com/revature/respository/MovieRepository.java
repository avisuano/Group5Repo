package com.revature.respository;

import java.util.List;

import com.revature.model.Movie;

public interface MovieRepository {

	List<Movie> getAllMovies();
	void insertMovie(Movie movie);
	Movie getMovieById(int id);
	Movie getMovieByName(String name);
	void updateMovie(Movie movie);
}


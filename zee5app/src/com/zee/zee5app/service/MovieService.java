package com.zee.zee5app.service;

import java.util.Optional;

import com.zee.zee5app.dto.movies;

public interface MovieService {
	
	public String addMovie(movies Movie);
	
	public String updateMovie(String id, movies movie);
	
	public String deleteMovie(String id);
	
	public Optional<movies> getMovieById(String id);
	
	public movies[] getAllMovie();
}

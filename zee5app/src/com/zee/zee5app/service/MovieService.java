package com.zee.zee5app.service;

import java.util.Optional;

import com.zee.zee5app.dto.movies;
import com.zee.zee5app.dto.subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;

public interface MovieService {
	
	public String addMovie(movies Movie);
	
	public String updateMovie(String id, movies movie) throws IdNotFoundException;
	
	public String deleteMovie(String id) throws IdNotFoundException;
	
	public Optional<movies> getMovieById(String id) throws IdNotFoundException;
	
	public Optional<movies> getMovieByName(String name) throws NameNotFoundException, LocationNotFoundException;
	
	public movies[] getAllMovie();
}

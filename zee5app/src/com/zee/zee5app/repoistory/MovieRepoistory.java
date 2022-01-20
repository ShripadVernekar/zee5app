package com.zee.zee5app.repoistory;

import java.util.Optional;

import com.zee.zee5app.dto.movies;


public interface MovieRepoistory {

	
	//update user info
	public String updateMovie(String id, movies movie);
	
	//delete movie
	public String deleteMovie(String id) ;
	
	//get movie details based on id's
	public Optional<movies> getMovieById(String id);
	
	// to return all user details
	public movies[] getAllMovie() ;
	
	// add a new movie
	public String addMovie(movies movie) ;

}

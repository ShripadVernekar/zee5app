package com.zee.zee5app.repoistory;

import java.util.Optional;

import com.zee.zee5app.dto.movies;
import com.zee.zee5app.dto.subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.service.SubscriptionService;


public interface MovieRepoistory {

	
	//update user info
	public String updateMovie(String id, movies movie) throws IdNotFoundException;
	
	//delete movie
	public String deleteMovie(String id) throws IdNotFoundException ;
	
	//get movie details based on id's
	public Optional<movies> getMovieById(String id) throws IdNotFoundException;
	
	public Optional<movies> getMovieByName(String name) throws NameNotFoundException;
	
	public String watchMovie(String moviename) throws NameNotFoundException, LocationNotFoundException;
	
	// to return all user details
	public movies[] getAllMovie() ;
	
	// add a new movie
	public String addMovie(movies movie) ;

	Optional<movies> getMoviedetails(String name) throws NameNotFoundException, LocationNotFoundException;

}

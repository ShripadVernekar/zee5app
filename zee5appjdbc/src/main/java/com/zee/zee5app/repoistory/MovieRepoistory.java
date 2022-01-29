package com.zee.zee5app.repoistory;

import java.util.ArrayList;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.movies;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;


public interface MovieRepoistory {

	
	//update user info
	public String updateMovie(String id, movies movie) throws IdNotFoundException;
	
	//delete movie
	public String deleteMovie(String id) throws IdNotFoundException ;
	
	//get movie details based on id's
	public Optional<movies> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException;
	
	public Optional<movies> getMovieByName(String name) throws NameNotFoundException, InvalidIdLengthException, InvalidNameException;
	
	public String watchMovie(String moviename) throws NameNotFoundException, LocationNotFoundException;
	
	// to return all user details
	public Optional<ArrayList<movies>> getAllMovie() throws InvalidIdLengthException, InvalidNameException ;
	
	// add a new movie
	public String addMovie(movies movie) ;

}

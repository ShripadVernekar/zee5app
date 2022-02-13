package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;

public interface MovieService {

	public Movies addMovie(Movies movie);

	public String updateMovie(Long id, Movies movie) throws IdNotFoundException;

	public String deleteMovie(Long id) throws IdNotFoundException;

	public Optional<Movies> getMovieById(Long id)
			throws IdNotFoundException, InvalidNameException, InvalidIdLengthException;

	public Optional<Movies> getMovieByName(String name)
			throws NameNotFoundException, LocationNotFoundException, InvalidNameException, InvalidIdLengthException;

	public Optional<List<Movies>> getAllMovie() ;
}

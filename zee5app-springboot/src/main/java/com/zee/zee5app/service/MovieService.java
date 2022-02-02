package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.movies;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;

public interface MovieService {

	public String addMovie(movies Movie);

	public String updateMovie(String id, movies movie) throws IdNotFoundException;

	public String deleteMovie(String id) throws IdNotFoundException;

	public Optional<movies> getMovieById(String id)
			throws IdNotFoundException, InvalidNameException, InvalidIdLengthException;

	public Optional<movies> getMovieByName(String name)
			throws NameNotFoundException, LocationNotFoundException, InvalidNameException, InvalidIdLengthException;

	public Optional<ArrayList<movies>> getAllMovie() throws InvalidNameException, InvalidIdLengthException;
}

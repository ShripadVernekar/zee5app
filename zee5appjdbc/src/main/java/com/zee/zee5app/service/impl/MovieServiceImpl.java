package com.zee.zee5app.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.movies;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repoistory.MovieRepoistory;
import com.zee.zee5app.service.MovieService;

public class MovieServiceImpl implements MovieService {

	private static MovieRepoistory movieRepoistory;

	@Override
	public String addMovie(movies Movie) {
		// TODO Auto-generated method stub
		return movieRepoistory.addMovie(Movie);
	}

	@Override
	public String updateMovie(String id, movies movie) throws IdNotFoundException {
		return movieRepoistory.updateMovie(id, movie);
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		return movieRepoistory.deleteMovie(id);
	}

	@Override
	public Optional<movies> getMovieById(String id)
			throws IdNotFoundException, InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return movieRepoistory.getMovieById(id);
	}

	@Override
	public Optional<ArrayList<movies>> getAllMovie() throws InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return movieRepoistory.getAllMovie();
	}

	@Override
	public Optional<movies> getMovieByName(String name)
			throws NameNotFoundException, InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return movieRepoistory.getMovieByName(name);
	}

}

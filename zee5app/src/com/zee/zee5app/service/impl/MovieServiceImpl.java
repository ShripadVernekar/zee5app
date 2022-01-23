package com.zee.zee5app.service.impl;

import java.util.Optional;

import com.zee.zee5app.dto.movies;
import com.zee.zee5app.dto.subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repoistory.MovieRepoistory;
import com.zee.zee5app.repoistory.impl.MovieRepositoryImpl;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SubscriptionService;

public class MovieServiceImpl implements MovieService {

	private static MovieService movieService;
	
	public static MovieService getInstance() {
		if(movieService == null)
			movieService = new MovieServiceImpl();
		return movieService;
	}
	
	MovieRepoistory movieRepoistory = MovieRepositoryImpl.getInstance();
	
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
	public Optional<movies> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return movieRepoistory.getMovieById(id);
	}

	@Override
	public movies[] getAllMovie() {
		// TODO Auto-generated method stub
		return movieRepoistory.getAllMovie();
	}

	@Override
	public Optional<movies> getMovieByName(String name) throws NameNotFoundException {
		// TODO Auto-generated method stub
		return movieRepoistory.getMovieByName(name);
	}

	

}

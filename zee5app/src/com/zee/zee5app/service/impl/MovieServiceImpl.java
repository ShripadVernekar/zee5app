package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.movies;
import com.zee.zee5app.repoistory.MovieRepoistory;
import com.zee.zee5app.repository.impl.MovieRepositoryImpl;
import com.zee.zee5app.service.MovieService;

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
	public String updateMovie(String id, movies movie) {
		// TODO Auto-generated method stub
		return movieRepoistory.updateMovie(id, movie);
	}

	@Override
	public String deleteMovie(String id) {
		// TODO Auto-generated method stub
		return movieRepoistory.deleteMovie(id);
	}

	@Override
	public movies getMovieById(String id) {
		// TODO Auto-generated method stub
		return movieRepoistory.getMovieById(id);
	}

	@Override
	public movies[] getAllMovie() {
		// TODO Auto-generated method stub
		return movieRepoistory.getAllMovie();
	}

}

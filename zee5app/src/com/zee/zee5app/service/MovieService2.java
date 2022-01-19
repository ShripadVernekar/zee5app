package com.zee.zee5app.service;

import com.zee.zee5app.dto.movies;
import com.zee.zee5app.repoistory.MovieRepoistory;

public class MovieService2 {
	
	private MovieRepoistory repository = MovieRepoistory.getInstance();
	
	private MovieService2() {
		
	}
	
	private static MovieService2 service = null;
	
	public static MovieService2 getInstance() {
		
		if (service == null)
			service = new MovieService2();
		return service;
	}
	
	public String addMovie(movies Movie) {
		return this.repository.addMovie(Movie);
	}
	
	public String updateMovie(String id, movies movie) {
		return this.repository.updateMovie(id,movie);
	}
	
	public String deleteMovie(String id) {
		return this.repository.deleteMovie(id);
	}
	
	public movies getMovieById(String id) {
		return this.repository.getMovieById(id);
	}
	
	public movies[] getAllMovie() {
		return this.repository.getAllMovie();
	}
}

package com.zee.zee5app.movie_service;

import com.zee.zee5app.movie_dto.movies;
import com.zee.zee5app.movie_repoistory.MovieRepoistory;

public class MovieService {
	
	private MovieRepoistory repository = MovieRepoistory.getInstance();
	
	private MovieService() {
		
	}
	
	private static MovieService service = null;
	
	public static MovieService getInstance() {
		
		if (service == null)
			service = new MovieService();
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

package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.movies;
import com.zee.zee5app.repoistory.MovieRepoistory;

public class MovieRepositoryImpl implements MovieRepoistory {

	private movies[] mov = new movies[10];
	private static int count = -1;
	
	private MovieRepositoryImpl() {
		
	}
	
	private static MovieRepoistory movieRepository;
	
	public static MovieRepoistory getInstance() {
		if (movieRepository == null)
			movieRepository = new MovieRepositoryImpl();
		return movieRepository;
	}
	
	@Override
	public String updateMovie(String id, movies movie) {
		// TODO Auto-generated method stub
		int i = 0;
		for(i=0; i< mov.length; i++) {
			if(mov[i] != null && mov[i].getId().equals(id)) {
				mov[i] = movie;
				return "done";
			}
		}

		return "not found";
	}

	@Override
	public String deleteMovie(String id) {
		// TODO Auto-generated method stub
		int i = 0;
		for(i=0; i< mov.length; i++) {
			if(mov[i] != null && mov[i].getId().equals(id)) {
				mov[i] = mov[i+1];
			}
		}
		if(i == mov.length)
			return null;
		return "done";
	}

	@Override
	public movies getMovieById(String id) {
		// TODO Auto-generated method stub
		 for (movies movie : mov) {
			 if (movie !=null && movie.getId().equals(id))
				 return movie;
		 }
		 return null;
	}

	@Override
	public movies[] getAllMovie() {
		// TODO Auto-generated method stub
		return mov;
	}
	
	// add a new movie
	public String addMovie(movies movie) {
		
		if(count == mov.length-1) {
			movies temp[] = new movies[mov.length*2];
			System.arraycopy(mov, 0, temp, 0, mov.length);
			mov = temp;
			mov[++count] = movie;
			return "success";
		}
		
		mov[++count] = movie;
		return "success";
	}

}

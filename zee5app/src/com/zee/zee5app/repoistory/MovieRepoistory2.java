package com.zee.zee5app.repoistory;

import com.zee.zee5app.dto.movies;

import lombok.Data;

@Data
public class MovieRepoistory2 {

	private movies[] mov = new movies[10];
	private static int count = -1;
	private static MovieRepoistory2 movieRepository;
	
	//update user info
	public String updateMovie(String id, movies movie) {
		int i = 0;
		for(i=0; i< mov.length; i++) {
			if(mov[i] != null && mov[i].getId().equals(id)) {
				mov[i] = movie;
				return "done";
			}
		}

		return "not found";
	}
	
	//delete movie
	public String deleteMovie(String id) {
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
	
	//get movie details based on id's
	public movies getMovieById(String id) {
		 for (movies movie : mov) {
			 if (movie !=null && movie.getId().equals(id))
				 return movie;
		 }
		 return null;
	}
	
	// to return all user details
	public movies[] getAllMovie() {
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
	
	public static MovieRepoistory2 getInstance() {
		if(movieRepository==null)
			movieRepository = new MovieRepoistory2();
		return movieRepository;
	}
}

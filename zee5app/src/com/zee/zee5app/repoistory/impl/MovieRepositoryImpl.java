package com.zee.zee5app.repoistory.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.zee.zee5app.dto.movies;
import com.zee.zee5app.dto.subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repoistory.MovieRepoistory;

public class MovieRepositoryImpl implements MovieRepoistory {

	private Set<movies> hashSet = new HashSet<movies>();
//	private static int count = -1;
	
	private MovieRepositoryImpl() {
		
	}
	
	private static MovieRepoistory movieRepository;
	
	subscription Sub = new subscription();
	
	public static MovieRepoistory getInstance() {
		if (movieRepository == null)
			movieRepository = new MovieRepositoryImpl();
		return movieRepository;
	}

	@Override
	public String updateMovie(String id, movies movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<movies> optional = this.getMovieById(id);
		if (optional.isPresent()) {
			hashSet.remove(optional.get());
			boolean res = hashSet.add(movie);
			if(res) {
				return "Done";
			}else {
				return "fail";
			}
		}
		return "fail";
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<movies> optional = this.getMovieById(id);
		if (optional.isPresent()) {
			boolean res = hashSet.remove(optional.get());
			if(res) {
				return "Done";
			}else {
				return "fail";
			}
		}
		return "fail";
	}

	@Override
	public Optional<movies> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		movies mov = null;
		 for (movies Movies : hashSet) {
		 if (Movies.getId().equals(id)) {
			 mov = Movies;
			 break;
		 	}
		 }
		 return Optional.of(Optional
				.ofNullable(mov)
				.orElseThrow(()-> new IdNotFoundException("Id not found!")));
	}
	
	public Optional<movies> getMovieByName(String name) throws NameNotFoundException {
		// TODO Auto-generated method stub
		movies mov = null;
		 for (movies Movies : hashSet) {
			 if (Movies.getMovieName().equals(name)) {
					 mov = Movies;
					 break;
			 	}
		 }
		 return Optional.of(Optional
				.ofNullable(mov)
				.orElseThrow(()-> new NameNotFoundException("Movie name not found!")));
	}


	@Override
	public movies[] getAllMovie() {
		// TODO Auto-generated method stub
		movies Movies[] = new movies[hashSet.size()];
		return hashSet.toArray(Movies);
	}

	@Override
	public String addMovie(movies movie) {
		// TODO Auto-generated method stub
		boolean res = this.hashSet.add(movie);
		if (res)
			return "success";
		return "failed";
	}
	
	@Override
	public Optional<movies> getMoviedetails(String name) throws NameNotFoundException, LocationNotFoundException {
		// TODO Auto-generated method stub
		movies mov=null;
		for(movies s: hashSet)		{	
			System.out.println(s);
			if(name.equals(s.getMovieName())){
				mov=s;
				break;
			}
				
		}
		
		return Optional.of(Optional.ofNullable(mov).orElseThrow(()->new NameNotFoundException("movie does not exist")));
	}
	
	@Override
	public String watchMovie(String moviename) throws NameNotFoundException, LocationNotFoundException {
		System.out.println(moviename);
		Optional<movies> mov=getMoviedetails(moviename);
		if(mov.isPresent()){
			
			if(mov.get().getAllowedLocations().equals("India")){
				return "Movie Available";
			}
			else{
				throw new  LocationNotFoundException("Movie is not available in your location");
			}
		}
		else {
			 throw new NameNotFoundException("Name Not Found");
		}
		
	}
	
	
//	@Override
//	public String updateMovie(String id, movies movie) {
//		// TODO Auto-generated method stub
//		int i = 0;
//		for(i=0; i< mov.length; i++) {
//			if(mov[i] != null && mov[i].getId().equals(id)) {
//				mov[i] = movie;
//				return "done";
//			}
//		}
//
//		return "not found";
//	}
//
//	@Override
//	public String deleteMovie(String id) {
//		// TODO Auto-generated method stub
//		int i = 0;
//		for(i=0; i< mov.length; i++) {
//			if(mov[i] != null && mov[i].getId().equals(id)) {
//				mov[i] = mov[i+1];
//			}
//		}
//		if(i == mov.length)
//			return null;
//		return "done";
//	}
//
//	@Override
//	public movies getMovieById(String id) {
//		// TODO Auto-generated method stub
//		 for (movies movie : mov) {
//			 if (movie !=null && movie.getId().equals(id))
//				 return movie;
//		 }
//		 return null;
//	}
//
//	@Override
//	public movies[] getAllMovie() {
//		// TODO Auto-generated method stub
//		return mov;
//	}
//	
//	// add a new movie
//	public String addMovie(movies movie) {
//		
//		if(count == mov.length-1) {
//			movies temp[] = new movies[mov.length*2];
//			System.arraycopy(mov, 0, temp, 0, mov.length);
//			mov = temp;
//			mov[++count] = movie;
//			return "success";
//		}
//		
//		mov[++count] = movie;
//		return "success";
//	}

}

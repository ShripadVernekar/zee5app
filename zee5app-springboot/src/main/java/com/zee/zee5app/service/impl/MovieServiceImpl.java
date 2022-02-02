package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.movies;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repository.MoviesRepository;
import com.zee.zee5app.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private  MoviesRepository MovieRepository;

	@Override
	public String addMovie(movies Movie) {
		// TODO Auto-generated method stub
		movies movies = MovieRepository.save(Movie);
		if (movies != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<movies> optional;
		try {
			optional = this.getMovieById(id);
			if (optional.isEmpty()) {
				throw new IdNotFoundException("id not found!");
			} else {
				MovieRepository.deleteById(id);
				return "success";
			}
		} catch (InvalidNameException | IdNotFoundException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<movies> getMovieById(String id)
			throws IdNotFoundException, InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return MovieRepository.findById(id);
	}

	@Override
	public Optional<movies> getMovieByName(String name)
			throws NameNotFoundException, LocationNotFoundException, InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public Optional<List<movies>> getAllMovie() throws InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(MovieRepository.findAll());
	}

	@Override
	public String updateMovie(String id, movies movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

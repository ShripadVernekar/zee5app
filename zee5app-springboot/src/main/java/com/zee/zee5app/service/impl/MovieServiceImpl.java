package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repository.MoviesRepository;
import com.zee.zee5app.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private  MoviesRepository movieRepository;

	@Override
	public Movies addMovie(Movies movie) {
		// TODO Auto-generated method stub
		Movies movies = movieRepository.save(movie);
		if (movies != null) {
			return movies;
		} else {
			return null;
		}
	}

	@Override
	public String deleteMovie(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movies> optional;
		try {
			optional = this.getMovieById(id);
			if (optional.isEmpty()) {
				throw new IdNotFoundException("id not found!");
			} else {
				movieRepository.deleteById(id);
				return "success";
			}
		} catch (InvalidNameException | IdNotFoundException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<Movies> getMovieById(Long id)
			throws IdNotFoundException, InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return movieRepository.findById(id);
	}

	@Override
	public Optional<Movies> getMovieByName(String name)
			throws NameNotFoundException, LocationNotFoundException, InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public Optional<List<Movies>> getAllMovie() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieRepository.findAll());
	}

	@Override
	public String updateMovie(Long id, Movies movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.zee.zee5app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.payload.request.MovieRequest;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.repository.MoviesRepository;
import com.zee.zee5app.service.MovieService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@Autowired
	MoviesRepository moviesRepository;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/addMovie")
	public ResponseEntity<?> addMovie(@Valid @RequestBody MovieRequest movieRequest){

		if(moviesRepository.existsByMovieName(movieRequest.getMovieName())) {
			return ResponseEntity.badRequest()
					 .body(new MessageResponse("Error: Movie with name: "+movieRequest.getMovieName()+" exists!"));
		}
		
		Movies movies = new Movies(movieRequest.getMovieName(),
				movieRequest.getAgeLimit(),
				movieRequest.getGenre(),
				movieRequest.getLanguage(),
				movieRequest.getTrailer(),
				movieRequest.getCast(),
				movieRequest.getLength(),
				movieRequest.getReleaseDate());
		
		moviesRepository.save(movies);
		return ResponseEntity.status(201).body(new MessageResponse("Movie added successfully"));
	}

	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@GetMapping("/getMovie/{moviename}")
	public ResponseEntity<?> getMovie(@PathVariable("moviename") String moviename) {

		if (moviesRepository.existsByMovieName(moviename)) {
			Optional<Movies> movie1 = moviesRepository.findByMovieName(moviename);
			return ResponseEntity.ok(movie1);
		}
		return ResponseEntity.badRequest()
				 .body(new MessageResponse("Error: Movie with name: "+moviename+" does not exists!"));
	}
	
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@GetMapping("/all")
	public ResponseEntity<?> getAllMovies() {
		Optional<List<Movies>> optional = movieService.getAllMovie();
		
		if(optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("No record found"));
		}
		return ResponseEntity.ok(optional.get());
	}
	 
}

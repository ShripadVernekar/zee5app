package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {

	// "exists" word to check and get boolean result
	Boolean existsByMovieName(String movieName);
	
	// "find" word to retrieve details here by moviename and language
	Optional<Movies> findByMovieNameAndLanguage(String movieName, String language);
	
	Optional<Movies> findByMovieName(String movieName);
	
	Optional<Movies> findByMovieNameAndReleaseDate(String movieName, String releaseDate);
	
	Optional<List<Movies>> findByCast(String cast);
}

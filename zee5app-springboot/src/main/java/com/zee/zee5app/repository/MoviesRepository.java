package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.movies;

@Repository
public interface MoviesRepository extends JpaRepository<movies, String> {

	// "exists" word to check and get boolean result
	Boolean existsByMovieName(String movieName);
	
	// "find" word to retrieve details here by moviename and language
	Optional<movies> findByMovieNameAndLanguage(String moviename, String language);
	
	Optional<movies> findByMovieName(String moviename);
	
	Optional<movies> findByMovieNameAndReleaseDate(String moviename, String releaseDate);
	
	Optional<List<movies>> findByCast(String cast);
}

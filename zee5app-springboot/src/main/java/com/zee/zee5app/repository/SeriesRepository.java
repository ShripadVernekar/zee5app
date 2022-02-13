package com.zee.zee5app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Series;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {

	Boolean existsBySeriesName(String seriesName);
	Optional<Series> findBySeriesNameAndLanguage(String seriesName, String language);
	Optional<Series> findBySeriesName(String seriesName);
//	Optional<series> findBySeriesNameAndReleaseDate(String seriesName, String releaseDate);

}

package com.zee.zee5app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.series;

@Repository
public interface SeriesRepository extends JpaRepository<series, String> {

	Optional<series> findBySeriesNameAndLanguage(String seriesName, String language);
//	Optional<series> findBySeriesName(String seriesName);
//	Optional<series> findBySeriesNameAndReleaseDate(String seriesName, String releaseDate);

}

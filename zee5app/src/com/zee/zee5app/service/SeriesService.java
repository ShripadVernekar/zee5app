package com.zee.zee5app.service;

import java.util.Optional;

import com.zee.zee5app.dto.movies;
import com.zee.zee5app.dto.series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;

public interface SeriesService {

		public String addSeries(series Series);
		
		public String updateSeries(String id, series Series) throws IdNotFoundException;
		
		public String deleteSeries(String id) throws IdNotFoundException;
		
		public Optional<series> getSeriesById(String id) throws IdNotFoundException;
		public Optional<series> getSeriesByName(String name, String country) throws NameNotFoundException, LocationNotFoundException;
		
		public series[] getAllSeries();
}

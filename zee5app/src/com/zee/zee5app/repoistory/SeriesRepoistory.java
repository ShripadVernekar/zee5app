package com.zee.zee5app.repoistory;

import java.util.Optional;

import com.zee.zee5app.dto.series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;

public interface SeriesRepoistory {
	
	//update Series info
	public String updateSeries(String id, series Series) throws IdNotFoundException;
	
	//delete Series
	public String deleteSeries(String id) throws IdNotFoundException;
	
	//get Series details based on id's
	public Optional<series> getSeriesById(String id) throws IdNotFoundException;
	// to return all series details
	public series[] getAllSeries();
	
	// add a new series
	public String addSeries(series Series);

	public Optional<series> getSeriesByName(String name,String country) throws NameNotFoundException, LocationNotFoundException;
	
}

package com.zee.zee5app.repoistory;

import com.zee.zee5app.dto.series;

public interface SeriesRepoistory {
	
	//update Series info
	public String updateSeries(String id, series Series);
	
	//delete Series
	public String deleteSeries(String id);
	
	//get Series details based on id's
	public series getSeriesById(String id);
	// to return all series details
	public series[] getAllSeries();
	
	// add a new series
	public String addSeries(series Series);
	
}

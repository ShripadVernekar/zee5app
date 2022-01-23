package com.zee.zee5app.service.impl;

import java.util.Optional;

import com.zee.zee5app.dto.series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repoistory.SeriesRepoistory;
import com.zee.zee5app.repoistory.impl.SeriesRepositoryImpl;
import com.zee.zee5app.service.SeriesService;

public class SeriesServieImpl implements SeriesService {

	private static SeriesService seriesService;
	
	public static SeriesService getInstance() {
		if(seriesService == null)
			seriesService = new SeriesServieImpl();
		return seriesService;
	}
	
	SeriesRepoistory seriesRepoistory = SeriesRepositoryImpl.getInstance();
	@Override
	public String addSeries(series Series) {
		return seriesRepoistory.addSeries(Series);
	}

	@Override
	public String updateSeries(String id, series Series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepoistory.updateSeries(id, Series);
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepoistory.deleteSeries(id);
	}

	@Override
	public Optional<series> getSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepoistory.getSeriesById(id);
	}
	
	@Override
	public Optional<series> getSeriesByName(String name, String country) throws NameNotFoundException, LocationNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepoistory.getSeriesByName(name,country);
	}

	@Override
	public series[] getAllSeries() {
		// TODO Auto-generated method stub
		return seriesRepoistory.getAllSeries();
	}

}

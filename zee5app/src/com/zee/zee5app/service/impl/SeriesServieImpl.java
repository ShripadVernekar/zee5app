package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.series;
import com.zee.zee5app.repoistory.SeriesRepoistory;
import com.zee.zee5app.repository.impl.SeriesRepositoryImpl;
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
		// TODO Auto-generated method stub
		return seriesRepoistory.addSeries(Series);
	}

	@Override
	public String updateSeries(String id, series Series) {
		// TODO Auto-generated method stub
		return seriesRepoistory.updateSeries(id, Series);
	}

	@Override
	public String deleteSeries(String id) {
		// TODO Auto-generated method stub
		return seriesRepoistory.deleteSeries(id);
	}

	@Override
	public series getSeriesById(String id) {
		// TODO Auto-generated method stub
		return seriesRepoistory.getSeriesById(id);
	}

	@Override
	public series[] getAllSeries() {
		// TODO Auto-generated method stub
		return seriesRepoistory.getAllSeries();
	}

}

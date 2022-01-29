package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repoistory.SeriesRepoistory;
import com.zee.zee5app.repoistory.impl.SeriesRepositoryImpl;
import com.zee.zee5app.service.SeriesService;

public class SeriesServieImpl implements SeriesService {

	private static SeriesService seriesService;
	private static SeriesRepoistory seriesRepoistory;

	private SeriesServieImpl() throws IOException {
		seriesRepoistory = SeriesRepositoryImpl.getInstance();
	}

	public static SeriesService getInstance() throws IOException {
		if (seriesService == null)
			seriesService = new SeriesServieImpl();
		return seriesService;
	}

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
	public Optional<series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return seriesRepoistory.getSeriesById(id);
	}

	@Override
	public Optional<ArrayList<series>> getAllSeries() throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		return seriesRepoistory.getAllSeries();
	}

}

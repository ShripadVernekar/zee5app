package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;

public interface SeriesService {

	public String addSeries(Series series);

	public String updateSeries(Long id, Series series) throws IdNotFoundException;

	public String deleteSeries(Long id) throws IdNotFoundException;

	public Optional<Series> getSeriesById(Long id) throws IdNotFoundException, InvalidIdLengthException;

	public Optional<List<Series>> getAllSeries();
}

package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;

public interface SeriesService {

	public String addSeries(Series series);

	public String updateSeries(String id, Series series) throws IdNotFoundException;

	public String deleteSeries(String id) throws IdNotFoundException;

	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException;

	public Optional<List<Series>> getAllSeries() throws InvalidIdLengthException;
}

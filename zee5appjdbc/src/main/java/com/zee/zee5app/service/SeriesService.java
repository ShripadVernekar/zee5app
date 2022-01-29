package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;

public interface SeriesService {

	public String addSeries(series Series);

	public String updateSeries(String id, series Series) throws IdNotFoundException;

	public String deleteSeries(String id) throws IdNotFoundException;

	public Optional<series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException;

	public Optional<ArrayList<series>> getAllSeries() throws InvalidIdLengthException;
}

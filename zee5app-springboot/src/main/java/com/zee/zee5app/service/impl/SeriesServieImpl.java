package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.service.SeriesService;

@Service

public class SeriesServieImpl implements SeriesService {

	@Autowired
	private  SeriesRepository SeriesRepository;

	@Override
	public String addSeries(series Series) {
		series series2 = SeriesRepository.save(Series);
		if(series2 != null) {
			return "success";
		}else {
			return "fail";
		}
	}

	
	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<series> optional;
		try {
			optional = this.getSeriesById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("id not found!");
			}else {
				SeriesRepository.deleteById(id);
				return "success";
			}
		} catch (IdNotFoundException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
		 
	}

	@Override
	public Optional<series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return SeriesRepository.findById(id);
	}

	@Override
	public Optional<List<series>> getAllSeries() throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(SeriesRepository.findAll());
	}
	
	@Override
	public String updateSeries(String id, series Series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.zee.zee5app.service;

import com.zee.zee5app.dto.series;

public interface SeriesService {

		public String addSeries(series Series);
		
		public String updateSeries(String id, series Series);
		
		public String deleteSeries(String id);
		
		public series getSeriesById(String id);
		
		public series[] getAllSeries();
}

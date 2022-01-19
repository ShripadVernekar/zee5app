package com.zee.zee5app.series_service;

import com.zee.zee5app.series_dto.series;
import com.zee.zee5app.series_repoistory.SeriesRepoistory;

public class SeriesService {

		private SeriesRepoistory repository = SeriesRepoistory.getInstance();
		
		private SeriesService() {
			
		}
		
		private static SeriesService service = null;
		
		public static SeriesService getInstance() {
			if(service == null)
				service = new SeriesService();
			return service;
		}
		
		public String addSeries(series Series) {
			return this.repository.addSeries(Series);
		}
		
		public String updateSeries(String id, series Series) {
			return this.repository.updateSeries(id,Series);
		}
		
		public String deleteSeries(String id) {
			return this.repository.deleteSeries(id);
		}
		
		public series getSeriesById(String id) {
			return this.repository.getSeriesById(id);
		}
		
		public series[] getAllSeries() {
			return this.repository.getAllSeries();
		}
}

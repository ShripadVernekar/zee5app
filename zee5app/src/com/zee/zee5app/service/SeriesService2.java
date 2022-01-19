package com.zee.zee5app.service;

import com.zee.zee5app.dto.series;
import com.zee.zee5app.repoistory.SeriesRepoistory;

public class SeriesService2 {

		private SeriesRepoistory repository = SeriesRepoistory.getInstance();
		
		private SeriesService2() {
			
		}
		
		private static SeriesService2 service = null;
		
		public static SeriesService2 getInstance() {
			if(service == null)
				service = new SeriesService2();
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

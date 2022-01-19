package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.series;
import com.zee.zee5app.repoistory.SeriesRepoistory;

public class SeriesRepositoryImpl implements SeriesRepoistory {

	private series[] seriesArr = new series[10];
	private static int count = -1;
	private static SeriesRepoistory seriesRepoistory;
	
	private SeriesRepositoryImpl() {
		
	}
	
	@Override
	public String updateSeries(String id, series Series) {
		// TODO Auto-generated method stub
		int i = 0;
		for(i=0; i< seriesArr.length; i++) {
			if(seriesArr[i] != null && seriesArr[i].getId().equals(id)) {
				seriesArr[i] = Series;
				return "done";
			}
		}
		
		return "not found";
	}

	@Override
	public String deleteSeries(String id) {
		// TODO Auto-generated method stub
		int i = 0;
		for(i=0; i< seriesArr.length; i++) {
			if(seriesArr[i] != null && seriesArr[i].getId().equals(id)) {
				seriesArr[i] = seriesArr[i+1];
			}
		}
		if(i == seriesArr.length)
			return null;
		return "done";
	}

	@Override
	public series getSeriesById(String id) {
		// TODO Auto-generated method stub
		 for (series Series : seriesArr) {
			 if (Series !=null && Series.getId().equals(id))
				 return Series;
		 }
		 return null;
	}

	@Override
	public series[] getAllSeries() {
		// TODO Auto-generated method stub
		return seriesArr;
	}
	
	// add a new series
	public String addSeries(series Series) {
		
		if(count == seriesArr.length-1) {
			series temp[] = new series[seriesArr.length*2];
			System.arraycopy(seriesArr, 0, temp, 0, seriesArr.length);
			seriesArr = temp;
			seriesArr[++count] = Series;
			return "success";
		}
		
		seriesArr[++count] = Series;
		return "success";
	}
	
	public static SeriesRepoistory getInstance() {
		if(seriesRepoistory == null)
			seriesRepoistory = new SeriesRepositoryImpl();
		return seriesRepoistory;
	}
	

}

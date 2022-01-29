package com.zee.zee5app.repoistory;

import com.zee.zee5app.dto.series;

public class SeriesRepoistory2 {

	private series[] seriesArr = new series[10];
	private static int count = -1;
	private static SeriesRepoistory2 seriesRepoistory;
	
	//update Series info
	public String updateSeries(String id, series Series) {
		int i = 0;
		for(i=0; i< seriesArr.length; i++) {
			if(seriesArr[i] != null && seriesArr[i].getId().equals(id)) {
				seriesArr[i] = Series;
				return "done";
			}
		}
		
		return "not found";
	}
	
	//delete Series
	public String deleteSeries(String id) {
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
	
	//get Series details based on id's
	public series getSeriesById(String id) {
		 for (series Series : seriesArr) {
			 if (Series !=null && Series.getId().equals(id))
				 return Series;
		 }
		 return null;
	}
	
	// to return all series details
	public series[] getAllSeries() {
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
	
	public static SeriesRepoistory2 getInstance() {
		if(seriesRepoistory==null)
			seriesRepoistory = new SeriesRepoistory2();
		return seriesRepoistory;
	}
}

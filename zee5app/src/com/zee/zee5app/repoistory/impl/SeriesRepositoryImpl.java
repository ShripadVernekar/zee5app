package com.zee.zee5app.repoistory.impl;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.series;
import com.zee.zee5app.repoistory.SeriesRepoistory;

public class SeriesRepositoryImpl implements SeriesRepoistory {

//	private series[] seriesArr = new series[10];
	private ArrayList<series> arrayList = new ArrayList<series>();
//	private static int count = -1;
	private static SeriesRepoistory seriesRepoistory;
	
	private SeriesRepositoryImpl() {
		
	}
	
//	
	
	public static SeriesRepoistory getInstance() {
		if(seriesRepoistory == null)
			seriesRepoistory = new SeriesRepositoryImpl();
		return seriesRepoistory;
	}

	@Override
	public String updateSeries(String id, series Series) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSeries(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<series> getSeriesById(String id) {
		// TODO Auto-generated method stub
		series series2 = null;
		 for (series Series : arrayList) {
		 if (Series.getId().equals(id))
			 series2 = Series;
	 }
	 return Optional.ofNullable(series2);
	}

	@Override
	public series[] getAllSeries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addSeries(series Series) {
		// TODO Auto-generated method stub
		boolean res = this.arrayList.add(Series);
		if(res)
			return "success";
		return "failed";
		
	}
	
//	@Override
//	public String updateSeries(String id, series Series) {
//		// TODO Auto-generated method stub
//		int i = 0;
//		for(i=0; i< seriesArr.length; i++) {
//			if(seriesArr[i] != null && seriesArr[i].getId().equals(id)) {
//				seriesArr[i] = Series;
//				return "done";
//			}
//		}
//		
//		return "not found";
//	}
//
//	@Override
//	public String deleteSeries(String id) {
//		// TODO Auto-generated method stub
//		int i = 0;
//		for(i=0; i< seriesArr.length; i++) {
//			if(seriesArr[i] != null && seriesArr[i].getId().equals(id)) {
//				seriesArr[i] = seriesArr[i+1];
//			}
//		}
//		if(i == seriesArr.length)
//			return null;
//		return "done";
//	}
//
//	@Override
//	public series getSeriesById(String id) {
//		// TODO Auto-generated method stub
//		 for (series Series : seriesArr) {
//			 if (Series !=null && Series.getId().equals(id))
//				 return Series;
//		 }
//		 return null;
//	}
//
//	@Override
//	public series[] getAllSeries() {
//		// TODO Auto-generated method stub
//		return seriesArr;
//	}
//	
//	// add a new series
//	public String addSeries(series Series) {
//		
//		if(count == seriesArr.length-1) {
//			series temp[] = new series[seriesArr.length*2];
//			System.arraycopy(seriesArr, 0, temp, 0, seriesArr.length);
//			seriesArr = temp;
//			seriesArr[++count] = Series;
//			return "success";
//		}
//		
//		seriesArr[++count] = Series;
//		return "success";
//	}
	

}

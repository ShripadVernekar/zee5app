package com.zee.zee5app.repoistory.impl;

import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.dto.series;
import com.zee.zee5app.dto.subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repoistory.SeriesRepoistory;

public class SeriesRepositoryImpl implements SeriesRepoistory {

//	private series[] seriesArr = new series[10];
//	private ArrayList<series> arrayList = new ArrayList<series>();
	private TreeSet<series> set = new TreeSet<>();
	
	subscription Sub= new subscription();
//	private static int count = -1;
	private static SeriesRepoistory seriesRepoistory;
	
	private SeriesRepositoryImpl() {
		
	}
	
	
	public static SeriesRepoistory getInstance() {
		if(seriesRepoistory == null)
			seriesRepoistory = new SeriesRepositoryImpl();
		return seriesRepoistory;
	}

	@Override
	public String updateSeries(String id, series Series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<series> optional = this.getSeriesById(id);
		if (optional.isPresent()) {
			set.remove(optional.get());
			boolean res = set.add(Series);
			if(res) {
				return "Done";
			}else {
				return "fail";
			}
		}
		return "fail";
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<series> optional = this.getSeriesById(id);
		if (optional.isPresent()) {
			boolean res = set.remove(optional.get());
			if(res) {
				return "Done";
			}else {
				return "fail";
			}
		}
		return "fail";
	}
	
	@Override
	public Optional<series> getSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		series series2 = null;
		 for (series Series : set) {
		 if (Series.getId().equals(id)) {
			 series2 = Series;
			 break;
		 	}
		 }
		 return Optional.of(Optional
				.ofNullable(series2)
				.orElseThrow(()-> new IdNotFoundException("Id not found!")));
	}

	@Override
	public Optional<series> getSeriesByName(String name, String country) throws NameNotFoundException, LocationNotFoundException {
		// TODO Auto-generated method stub
		series series2 = null;
		 for (series Series : set) {
		 if (Series.getSeriesName().equals(name)) {
			 if (Sub.getPackCountry().equals(country)){
					 series2 = Series;
					 break;
			 }else {
				 throw new LocationNotFoundException("Series not available in your country");
			 }
		 	}
		 }
		 return Optional.of(Optional
				.ofNullable(series2)
				.orElseThrow(()-> new NameNotFoundException("Series Name not found!")));
	}
	
	@Override
	public series[] getAllSeries() {
		// TODO Auto-generated method stub
		series Series[] = new series[set.size()];
		return set.toArray(Series);
	}

	@Override
	public String addSeries(series Series) {
		// TODO Auto-generated method stub
		boolean res = this.set.add(Series);
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

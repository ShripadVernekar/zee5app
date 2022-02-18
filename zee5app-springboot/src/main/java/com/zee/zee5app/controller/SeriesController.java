package com.zee.zee5app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.payload.request.SeriesRequest;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.service.SeriesService;


@CrossOrigin("*")
@RestController

@RequestMapping("/api/series")
public class SeriesController {
	
	@Autowired
	SeriesService seriesService;
	
	@Autowired
	SeriesRepository seriesRepository;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/addSeries")
	public ResponseEntity<?> addSeries(@Valid @RequestBody SeriesRequest seriesRequest){
		System.out.println("======================="+seriesRequest);
		if(seriesRepository.existsBySeriesName(seriesRequest.getSeriesName())) {
			return ResponseEntity.badRequest()
					 .body(new MessageResponse("Error: Series with name: "+seriesRequest.getSeriesName()+" exists!"));
		}
		
		List<Episodes> episodes = seriesRequest.getEpisodes();		
		
		Series series = new Series(seriesRequest.getAgeLimit(), seriesRequest.getSeriesName(), 
				seriesRequest.getGenre(), seriesRequest.getLanguage(),
				seriesRequest.getTrailer(), seriesRequest.getCast(), 
				seriesRequest.getNoOfEpisodes(),seriesRequest.getReleaseDate(), episodes);
		
		seriesRepository.save(series);
		return ResponseEntity.status(201).body(new MessageResponse("Series added successfully"));
	}
	
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@GetMapping("/getSeries/{seriesname}")
	public ResponseEntity<?> getSeries(@PathVariable("seriesname") String seriesname) {

		if (seriesRepository.existsBySeriesName(seriesname)) {
			Optional<Series> series = seriesRepository.findBySeriesName(seriesname);
			return ResponseEntity.ok(series);
		}
		return ResponseEntity.badRequest()
				 .body(new MessageResponse("Error: Series with name: "+seriesname+" does not exists!"));
	}

	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@GetMapping("/all")
	public ResponseEntity<?> getAllSeries() {
		Optional<List<Series>> optional = seriesService.getAllSeries();
		
		if(optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("No record found"));
		}
		return ResponseEntity.ok(optional.get());
	}

	
}

package com.zee.zee5app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.payload.request.EpisodeRequest;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.repository.EpisodesRepository;
import com.zee.zee5app.service.EpisodeService;

@RestController

@RequestMapping("/api/episodes")
public class EpisodesController {
	
	@Autowired
	EpisodeService episodeService;
	
	@Autowired
	EpisodesRepository episodesRepository;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/addEpisode")
	public ResponseEntity<?> addEpisode(@Valid @RequestBody EpisodeRequest episodeRequest){
		
		if(episodesRepository.existsByEpisodeName(episodeRequest.getEpisodeName())) {
			return ResponseEntity.badRequest()
					 .body(new MessageResponse("Error: Episode with name: "+episodeRequest.getEpisodeName()+" exists!"));
		}
		
		Episodes episodes = new Episodes(episodeRequest.getEpisodeName(),
				episodeRequest.getEpiLength(),
				episodeRequest.getLocation(),
				episodeRequest.getTrailer());
		System.out.println(episodes);
		episodesRepository.save(episodes);
		return ResponseEntity.status(201).body(new MessageResponse("Episode added successfully"));
	}
	
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@GetMapping("/getEpisode/{episodename}")
	public ResponseEntity<?> getEpisode(@PathVariable("episodename") String episodename){

		if (episodesRepository.existsByEpisodeName(episodename)) {
			Optional<Episodes> series = episodesRepository.findByEpisodeName(episodename);
			return ResponseEntity.ok(series);
		}
		return ResponseEntity.badRequest()
				 .body(new MessageResponse("Error: Episode with name: "+episodename+" does not exists!"));
	}
	
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@GetMapping("/all")
	public ResponseEntity<?> getAllSeries() {
		Optional<List<Episodes>> optional = episodeService.getAllEpisodeList();
		
		if(optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("No record found"));
		}
		return ResponseEntity.ok(optional.get());
	}

}

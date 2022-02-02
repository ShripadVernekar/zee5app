package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;

public interface EpisodeService {
	public String addEpisode(Episodes episode) throws IdNotFoundException;

	public String updateEpisodeById(String id, Episodes episode) throws IdNotFoundException;

	public String deleteEpisodeById(String id) throws IdNotFoundException, InvalidIdLengthException;

	public Optional<Episodes> getEpisodeById(String id) throws IdNotFoundException, InvalidIdLengthException;

	public Optional<List<Episodes>> getAllEpisodeList() throws InvalidIdLengthException;
	
	public Episodes[] getAllEpisode() throws InvalidIdLengthException;
}

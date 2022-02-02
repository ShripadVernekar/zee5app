package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.EpisodesRepository;
import com.zee.zee5app.service.EpisodeService;

@Service
public class EpisodeServiceImpl implements EpisodeService {

	@Autowired
	private EpisodesRepository episodesRepository;

	@Override
	public String addEpisode(Episodes episode) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Episodes episodes = episodesRepository.save(episode);
		if (episodes != null) {
			return "success";
		} else {
			return "fail";
		}
	}

	@Override
	public String deleteEpisodeById(String id) throws IdNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		Optional<Episodes> optional;
		try {
			optional = this.getEpisodeById(id);
			if (optional.isEmpty()) {
				throw new IdNotFoundException("id not found!");
			} else {
				episodesRepository.deleteById(id);
				return "success";
			}
		} catch (IdNotFoundException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<Episodes> getEpisodeById(String id) throws IdNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(episodesRepository.getById(id));
	}

	@Override
	public Optional<List<Episodes>> getAllEpisodeList() throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(episodesRepository.findAll());
	}

	@Override
	public Episodes[] getAllEpisode() throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		List<Episodes> list = episodesRepository.findAll();
		Episodes[] arr = new Episodes[list.size()];
		return list.toArray(arr);
	}

	@Override
	public String updateEpisodeById(String id, Episodes episode) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}

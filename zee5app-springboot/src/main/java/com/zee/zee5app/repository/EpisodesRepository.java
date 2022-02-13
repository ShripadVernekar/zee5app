package com.zee.zee5app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Episodes;

@Repository
public interface EpisodesRepository extends JpaRepository<Episodes, Long> {

	Boolean existsByEpisodeName(String episodeName);
	
	Optional<Episodes> findByEpisodeName(String episodeName);
	
}

package com.goty.votes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goty.votes.model.Game;
import com.goty.votes.repository.IGotyRepository;

@Service
public class GotyServiceImpl implements IGotyService {
	@Autowired
	private IGotyRepository gotyRepository;
	
	@Override
	public List<Game> getVotes() {
		return (List<Game>) gotyRepository.findAll();
	}

	@Override
	public void vote(Game goty) {
		gotyRepository.save(goty);
	}

	@Override
	public Game getGame(Long id) {
		Optional<Game> optional = gotyRepository.findById(id);
		
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}

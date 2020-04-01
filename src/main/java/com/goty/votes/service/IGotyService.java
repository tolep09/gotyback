package com.goty.votes.service;

import java.util.List;

import com.goty.votes.model.Game;

public interface IGotyService {
	public abstract List<Game> getVotes();
	public abstract void vote(Game goty);
	public abstract Game getGame(Long id);
}

package com.goty.votes.repository;

import org.springframework.data.repository.CrudRepository;

import com.goty.votes.model.Game;

public interface IGotyRepository extends CrudRepository<Game, Long> {

}

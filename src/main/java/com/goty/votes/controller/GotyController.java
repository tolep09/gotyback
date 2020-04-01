package com.goty.votes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.goty.votes.model.Game;
import com.goty.votes.service.IGotyService;

@Controller
public class GotyController {
	@Autowired
	private IGotyService gotyService;
	
	@Autowired
	private SimpMessagingTemplate smTemplate;
	
	@MessageMapping("/vote")
	public void reciveVote(Game goty) {
		Game game = null;
		try {
			game = gotyService.getGame(goty.getId());
			
			if (game != null) {
				game.setVotes(game.getVotes() + 1);
				gotyService.vote(game);
				
			} else {
				System.out.println("No existe el juego seleccionado");
			}
			
		}catch(DataAccessException e) {
			System.out.println("Ocurrió una DataAccessException");
		}
		smTemplate.convertAndSend("/votes/actual/", gotyService.getVotes());
	}

	@MessageMapping("/votes")
	public void getAllVotes() {
		
		try {
			smTemplate.convertAndSend("/votes/actual/", gotyService.getVotes());
		}catch(DataAccessException e) {
			System.out.println("Ocurrió una DataAccessException");
		}
		
	} 
}

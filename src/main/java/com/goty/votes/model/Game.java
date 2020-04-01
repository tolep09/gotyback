package com.goty.votes.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Games")
public class Game implements Serializable{
	@Id
	private Long id;
	private String name;
	private Integer votes;
	private String image;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getVotes() {
		return votes;
	}
	public void setVotes(Integer votes) {
		this.votes = votes;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

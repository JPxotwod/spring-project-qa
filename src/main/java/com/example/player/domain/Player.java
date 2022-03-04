package com.example.player.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
	
	@Id //PRIMARY KEY
	
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO INCREMENT
	private Integer id;
	
    @Column(nullable = false)
	private String name;
	
    @Column(unique = true)
	private String position;
	
	private String team;
	
	private Integer number;

	public Player(Integer id, String name, String position, String team, Integer number) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.team = team;
		this.number = number;
	}
	
	public Player() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", position=" + position + ", team=" + team
				+ ", number=" + number + "]";
	}
	
}

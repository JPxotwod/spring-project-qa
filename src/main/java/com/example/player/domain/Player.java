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
	private Integer playerid;
	
    @Column(nullable = false)
	private String name;
	
    @Column(unique = true)
	private String position;
	
	private String team;
	
	private Integer number;

	public Player(Integer playerid, String name, String position, String team, Integer number) {
		super();
		this.playerid = playerid;
		this.name = name;
		this.position = position;
		this.team = team;
		this.number = number;
	}

	public Integer getPlayerid() {
		return playerid;
	}

	public void setPlayerid(Integer playerid) {
		this.playerid = playerid;
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
		return "Player [playerid=" + playerid + ", name=" + name + ", position=" + position + ", team=" + team
				+ ", number=" + number + "]";
	}
	
}

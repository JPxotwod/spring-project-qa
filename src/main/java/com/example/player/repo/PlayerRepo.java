package com.example.player.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.player.domain.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer> {
	
	//SPRING WILL AUTO-GENERATE ALL OF THE BASIC CRUD FUNCTIONALITY
	
	List<Player> findByNameIgnoreCase(String name);
	
	List<Player> findByNumber(Integer number);

}


package com.example.player.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.player.domain.Player;
import com.example.player.repo.PlayerRepo;

@Service
public class PlayerService implements ServiceIF<Player> {
	
	private PlayerRepo repo;
	
	@Autowired
	public PlayerService(PlayerRepo repo) {
		super();
		this.repo=repo;
	}

	// CREATE
	public Player create(Player p) {
		Player created = this.repo.save(p);//INSERT INTO Player;
		return created;
	}

	// READ
	public List<Player> getAll() {
		return this.repo.findAll();
	}

	public Player getOne(Integer id) {
		Optional<Player> found = this.repo.findById(id);
		return found.get();
	}

	public List<Player> getAllPlayersByNumber(Integer number) {
		List<Player> found = this.repo.findByNumber(number);
		return found;
	}
	
	public List<Player> getPlayersByName(String name) {
		List<Player> found = this.repo.findByNameIgnoreCase(name);
		return found;
	}
	
	
	// UPDATE
	public Player replace(Integer id, Player newPlayer) {
		Player existing = this.repo.findById(id).get();
		existing.setNumber(newPlayer.getNumber());
		existing.setPosition(newPlayer.getPosition());
		existing.setTeam(newPlayer.getTeam());
		existing.setName(newPlayer.getName());
		Player updated = this.repo.save(existing);
		return updated;
	}

	// DELETE
	public void remove(@PathVariable Integer id) {
		this.repo.deleteById(id); //DELETE FROM Player WHERE id=??
	}
}



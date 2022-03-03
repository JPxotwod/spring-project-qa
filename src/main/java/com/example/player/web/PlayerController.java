package com.example.player.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.player.domain.Player;
import com.example.player.service.PlayerService;

public class PlayerController {

	// ResponseEntity - an extension of HttpEntity that represents an Http response
	// including status, headers and body

	private PlayerService service;

	@Autowired // tells Spring to fetch the PersonService from the context - dependency
				// injection
	public PlayerController(PlayerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create") // @RequestBody pulls the parameter from the body of the request
	public ResponseEntity<Player> createDog(@RequestBody Player p) {
		Player created = this.service.create(p);
		ResponseEntity<Player> response = new ResponseEntity<Player>(created, HttpStatus.CREATED); // 201 - created status
																								// code
		return response;
	}

	@GetMapping("/getAll") // 200 - ok status code
	public ResponseEntity<List<Dog>> getAllPupps() {
		return ResponseEntity.ok(this.service.getAll());
	}

	@GetMapping("/get/{id}") // 200 - ok status code
	public Dog getDog(@PathVariable Integer id) {
		return this.service.getOne(id);

	}

	@PutMapping("/replace/{id}") // 202 - accepted status code
	public ResponseEntity<Dog> replaceDog(@PathVariable Integer id, @RequestBody Dog newDog) {
		Dog body = this.service.replace(id, newDog);
		ResponseEntity<Dog> response = new ResponseEntity<Dog>(body, HttpStatus.ACCEPTED);
		return response;
	}

	@DeleteMapping("/remove/{id}") // 204 - no content status code
	public ResponseEntity<?> removeDog(@PathVariable Integer id) {
		this.service.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/getByName/{name}") // 200 - ok status code
	public ResponseEntity<List<Dog>> getDogByName(@PathVariable String name) {
		List<Dog> found = this.service.getPuppsByName(name);
		return ResponseEntity.ok(found);
	}
	
	@GetMapping("/getByAge/{age}") // 200 - ok status code
	public ResponseEntity<List<Dog>> getDogByAge(@PathVariable Integer age) {
		List<Dog> found = this.service.getAllPuppsByAge(age);
		return ResponseEntity.ok(found);
	}
}
	
}

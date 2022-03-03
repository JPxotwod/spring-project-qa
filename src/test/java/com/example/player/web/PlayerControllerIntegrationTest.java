package com.example.player.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.player.domain.Player;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up MockMVC object
@Sql(scripts = { "classpath:player-schema.sql",
		"classpath:player-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class PlayerControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper; // java > JSON converter

	@Test
	void testCreate() throws Exception {
		Player testPlayer = new Player(null, "Lionel Messi", "PSG", "Attacker", 30);
		String testPlayerAsJSON = this.mapper.writeValueAsString(testPlayer);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testPlayerAsJSON);

		Player testCreatedPlayer = new Player(1, "Lionel Messi", "PSG", "Attacker", 30);
		String testCreatedPlayerAsJSON = this.mapper.writeValueAsString(testCreatedPlayer);
		ResultMatcher checkStatus = status().isCreated(); // status 201 - created
		ResultMatcher checkBody = content().json(testCreatedPlayerAsJSON); // check created body
		// sends the request and then checks the status in the body
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void getAllTest() throws Exception {
		RequestBuilder req = get("/getAll");
		List<Player> testPlayer = List.of(new Player(1, "Lionel Messi", "PSG", "Attacker", 30), new Player(2, "Cristiano Ronaldo", "Man U", "Attacker", 7));
		String json = this.mapper.writeValueAsString(testPlayer);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		// sends the request and then checks the status in the body
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetById() throws Exception {
		RequestBuilder req = get("/get/1");
		Player testPlayer = new Player(1, "Lionel Messi", "PSG", "Attacker", 30);
		String testGetByIdAsJSON = this.mapper.writeValueAsString(testPlayer);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testGetByIdAsJSON);
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetByName() throws Exception {
		RequestBuilder req = get("/getByName/Lionel Messi");
		List<Player> testPlayer = List.of(new Player(1, "Lionel Messi", "PSG", "Attacker", 30);
		String testGetByNameAsJSON = this.mapper.writeValueAsString(testPlayer);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testGetByNameAsJSON);
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetByNumber() throws Exception {
		RequestBuilder req = get("/getByNumber/30");
		List<Player> testPlayer = List.of(new Player(1, "Lionel Messi", "PSG", "Attacker", 30);
		String testGetByNumberAsJSON = this.mapper.writeValueAsString(testPlayer);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testGetByNumberAsJSON);
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testReplace() throws Exception {
		Player testPlayer = new Player(null, "Neymar", "PSG", "Attacker", 10);
		String testPlayerAsJSON = this.mapper.writeValueAsString(testPlayer);
		RequestBuilder req = put("/replace/1").contentType(MediaType.APPLICATION_JSON).content(testPlayerAsJSON);
		Player testReplacePlayer = new Player(1, "Neymar", "PSG", "Attacker", 10);
		String testReplacePlayerAsJSON = this.mapper.writeValueAsString(testReplacePlayer);
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testReplacePlayerAsJSON);
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testRemove() throws Exception {
		RequestBuilder req = delete("/remove/1");
		ResultMatcher checkStatus = status().isNoContent();
		this.mvc.perform(req).andExpect(checkStatus);
	}
}



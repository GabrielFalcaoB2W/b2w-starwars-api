package io.b2w.starwars.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.b2w.starwars.model.Planet;

@RestController
@RequestMapping("/api/planet")
@CrossOrigin("*")
public class PlanetController {

	@PostMapping
	public ResponseEntity<Planet> create(@RequestBody Planet planet) throws URISyntaxException {
		return ResponseEntity.created(new URI("/api/planet/".concat(planet.getId().toString()))).build();
	}

	@GetMapping
	public ResponseEntity<List<Planet>> findAll() {
		return null;
	}
	
	@GetMapping
	public ResponseEntity<Planet> findByName(@RequestParam("name") String name) {
		return null;
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public ResponseEntity<Planet> findById(@PathVariable("id") Long id) {
		return null;
	}
	
	@DeleteMapping
	@RequestMapping("/{id}")
	public ResponseEntity<Planet> remove(@PathVariable("id") Long id) {
		return null;
	}
}

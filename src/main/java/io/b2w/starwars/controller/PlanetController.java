package io.b2w.starwars.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import io.b2w.starwars.repository.PlanetRepository;
import io.b2w.starwars.service.PlanetService;

@RestController
@RequestMapping("/api/planets")
@CrossOrigin("*")
public class PlanetController {

	@Autowired
	private PlanetRepository planetRepo;
	
	@Autowired
	private PlanetService service;
	
	@Value("${io.b2w.starwars.path}")
	private String path;
	
	@Value("${io.b2w.starwars.endpoint.planet}")
	private String endpoint;
	
	@PostMapping
	public ResponseEntity<Planet> create(@Valid @RequestBody @NotNull Planet planet) throws URISyntaxException {
		service.insert(planet);
		return ResponseEntity.created(new URI(path.concat(endpoint.concat(planet.getId().toString())))).build();
	}

	@GetMapping
	public ResponseEntity<Page<Planet>> find(
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "page", defaultValue = "0") Integer page, 
			@RequestParam(name = "size", defaultValue = "5") Integer size
			) {
		return ResponseEntity.ok(service.find(name, PageRequest.of(page, size)));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Planet> findById(@PathVariable("id") String id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Planet> remove(@PathVariable("id") String id) {
		planetRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

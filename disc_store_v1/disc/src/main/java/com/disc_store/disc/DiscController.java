package com.disc_store.disc;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disc") // base path for Disc service
public class DiscController {

	private final DiscService service;

	public DiscController(DiscService service) {
		this.service = service;
	}

	// --- CRUD ---
	@GetMapping
	public List<Disc> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public Optional<Disc> getById(@PathVariable Long id) {
		return service.getById(id);
	}

	@PostMapping
	public Disc create(@RequestBody Disc disc) {
		return service.save(disc);
	}

	@PutMapping("/{id}")
	public Disc update(@PathVariable Long id, @RequestBody Disc updatedDisc) {
		return service.getById(id).map(disc -> {
			disc.setName(updatedDisc.getName());
			disc.setAuthor(updatedDisc.getAuthor());
			disc.setGenre(updatedDisc.getGenre());
			disc.setPrice(updatedDisc.getPrice());
			return service.save(disc);
		}).orElseGet(() -> {
			updatedDisc.setId(id);
			return service.save(updatedDisc);
		});
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
package com.disc_store.person;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping(path="/person")
	public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
		return ResponseEntity.ok(personService.createPerson(personDTO));
	}

	@GetMapping("/person/{id}")
	public ResponseEntity<PersonDTO> getPerson(@PathVariable Long id) {
		return ResponseEntity.ok(personService.getPersonById(id));
	}

	@GetMapping(path="/person")
	public ResponseEntity<List<PersonDTO>> getAllPersons() {
		return ResponseEntity.ok(personService.getAllPersons());
	}

	@PutMapping("/person/{id}")
	public ResponseEntity<PersonDTO> updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
		return ResponseEntity.ok(personService.updatePerson(id, personDTO));
	}

	@DeleteMapping("/person/{id}")
	public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
		personService.deletePerson(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/person/{id}/cashback")
	public ResponseEntity<Double> getCashback(@PathVariable Long id) {
		return ResponseEntity.ok(personService.calculateCashbackTotal(id));
	}
}

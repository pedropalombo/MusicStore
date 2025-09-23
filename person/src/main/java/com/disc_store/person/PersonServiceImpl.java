package com.disc_store.person;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

// class to implement the methods from 'PersonService'
@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;

	// constructor
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	// converter for Person -> PersonDTO
	private PersonDTO mapToDTO(Person person) {
		return new PersonDTO(person.getId(), person.getName(), person.getCashbackTotal());	// sending the data as a Bean
	}

	// -- Overriding the methods determined in 'PersonService' --
	@Override
	public PersonDTO createPerson(PersonDTO personDTO) {
		
		// creating an instance for the new customer
		Person person = new Person();
		
		// setting the customer details based on the request ('PersonDTO' structure)
		person.setName(personDTO.getName());
		person.setCashbackTotal(personDTO.getCashbackTotal());
		
		// saving the new customer to the db ...
		Person savedPerson = personRepository.save(person);
		
		// ... and returning them as a 'PersonDTO'
		return mapToDTO(savedPerson);
	}

	@Override
	public PersonDTO getPersonById(Long id) {
		
		// finding a customer by their id
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Person not found")		// throwing an exception if nothing is found
		);
		
		// returning the found customer as a 'PersonDTO'
		return mapToDTO(person);
	}

	@Override
	public List<PersonDTO> getAllPersons() {
		
		// returning every 'Person' from db
		return personRepository.findAll()
				.stream()	// setting the data as a Strem (for Spring purposes)
				.map(this::mapToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public PersonDTO updatePerson(Long id, PersonDTO personDTO) {
		
		// finding the given customer by their id
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Person not found")		// throwing and exception if nothing is found
		);
		
		
		// updating the given customer's details based on the request ('PersonDTO' structure)
		person.setName(personDTO.getName());
		person.setCashbackTotal(personDTO.getCashbackTotal());
		
		// saving the new customer to the db ...
		Person updatedPerson = personRepository.save(person);

		// ... and returning them as a 'PersonDTO'
		return mapToDTO(updatedPerson);
	}

	@Override
	public void deletePerson(Long id) {
		
		// deleting the customer from db using their id
		personRepository.deleteById(id);
	}

	@Override
	public Double calculateCashbackTotal(Long personId) {
		
		// first finding the customer to up their cashback value
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new RuntimeException("Person not found"));	// throwing and exception if nothing is found
		
		return person.getCashbackTotal().doubleValue();		// upping the value for the cashback
	}
}

package com.disc_store.person;

import java.util.List;

// skeleton class to contain the methods that'll be used for 'Person' CRUD/management
public interface PersonService {

	// creates a 'Person'
	PersonDTO createPerson(PersonDTO personDTO);

	// retrieves an specific 'Person'
	PersonDTO getPersonById(Long id);

	// returns all customers (list of 'Person')
	List<PersonDTO> getAllPersons();

	// allows for the update of a 'Person' based on their id
	PersonDTO updatePerson(Long id, PersonDTO personDTO);

	// removes a 'Person' using their id
	void deletePerson(Long id);

	// calculates the total cashback for given 'Person'
	Double calculateCashbackTotal(Long personId);
}
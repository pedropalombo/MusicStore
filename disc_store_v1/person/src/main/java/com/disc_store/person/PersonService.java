package com.disc_store.person;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getAll() {
        return repository.findAll();
    }

    public Optional<Person> getById(Long id) {
        return repository.findById(id);
    }

    public Person save(Person person) {
        return repository.save(person);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

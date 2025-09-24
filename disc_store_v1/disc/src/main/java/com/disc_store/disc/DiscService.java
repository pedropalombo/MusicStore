package com.disc_store.disc;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class DiscService {

    private final DiscRepository repository;

    public DiscService(DiscRepository repository) {
        this.repository = repository;
    }

    public List<Disc> getAll() {
        return repository.findAll();
    }

    public Optional<Disc> getById(Long id) {
        return repository.findById(id);
    }

    public Disc save(Disc disc) {
        return repository.save(disc);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
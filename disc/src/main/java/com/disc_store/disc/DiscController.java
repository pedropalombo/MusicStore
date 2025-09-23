package com.disc_store.disc;

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
public class DiscController {

    private final DiscService discService;	// fetching 'Disc's methods

    // setting up a controller for said methods
    public DiscController(DiscService discService) {
        this.discService = discService;
    }

    @PostMapping(path="/disc")
    public ResponseEntity<DiscDTO> createDisc(@RequestBody DiscDTO discDTO) {
        return ResponseEntity.ok(discService.createDisc(discDTO));
    }

    @GetMapping("/disc/{id}")
    public ResponseEntity<DiscDTO> getDisc(@PathVariable Long id) {
        return ResponseEntity.ok(discService.getDiscById(id));
    }

    @GetMapping(path="/disc")
    public ResponseEntity<List<DiscDTO>> getAllDiscs() {
        return ResponseEntity.ok(discService.getAllDiscs());
    }

    @PutMapping("/disc/{id}")
    public ResponseEntity<DiscDTO> updateDisc(@PathVariable Long id,
                                              @RequestBody DiscDTO discDTO) {
        return ResponseEntity.ok(discService.updateDisc(id, discDTO));
    }

    @DeleteMapping("/disc/{id}")
    public ResponseEntity<Void> deleteDisc(@PathVariable Long id) {
        discService.deleteDisc(id);
        return ResponseEntity.noContent().build();
    }
}
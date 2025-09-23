package com.disc_store.disc;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class DiscServiceImpl implements DiscService {

	private final DiscRepository discRepository;	// retrieving db's methods

	// constructor for the db instance
	public DiscServiceImpl(DiscRepository discRepository) {
		this.discRepository = discRepository;
	}
	
	// converting the 'Disc' to a DTO format
	private DiscDTO mapToDTO(Disc disc) {
		return new DiscDTO(disc.getId(), disc.getName(), disc.getAuthor(), disc.getGenre(), disc.getPrice());
	}

	@Override
	public DiscDTO createDisc(DiscDTO discDTO) {
		
		Disc disc = new Disc(discDTO.getName(), discDTO.getAuthor(), discDTO.getGenre(), discDTO.getPrice());
		
		Disc savedDisc = discRepository.save(disc);
		
		return mapToDTO(savedDisc);
	}

	@Override
	public DiscDTO getDiscById(Long id) {
		
		Disc disc = discRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Disc not found"));
		
		return mapToDTO(disc);
	}

	@Override
	public List<DiscDTO> getAllDiscs() {
		
		return discRepository.findAll()
				.stream()
				.map(this::mapToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public DiscDTO updateDisc(Long id, DiscDTO discDTO) {
		
		// finding the given CD by its id
		Disc disc = discRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Disc not found"));	// and throwing an exception if it's not found
		
		// updating the CD with the sent data
		disc.setName(discDTO.getName());
		disc.setAuthor(discDTO.getAuthor());
		disc.setGenre(discDTO.getGenre());
		disc.setPrice(discDTO.getPrice());
		
		
		// saving the changes to db
		Disc updatedDisc = discRepository.save(disc);
		
		// and converting it to a DTO structure
		return mapToDTO(updatedDisc);
	}

	@Override
	public void deleteDisc(Long id) {
		discRepository.deleteById(id);
	}
}

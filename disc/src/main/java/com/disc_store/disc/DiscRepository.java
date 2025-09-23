package com.disc_store.disc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository	// injecting db methods onto the class
public interface DiscRepository extends JpaRepository<Disc, Long> {
    // Additional query methods can be added here if needed
}
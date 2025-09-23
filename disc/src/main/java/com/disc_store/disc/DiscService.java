package com.disc_store.disc;

import java.util.List;

// instancing the methods to be used by 'Disc'
public interface DiscService {

    DiscDTO createDisc(DiscDTO discDTO);

    DiscDTO getDiscById(Long id);

    List<DiscDTO> getAllDiscs();

    DiscDTO updateDisc(Long id, DiscDTO discDTO);

    void deleteDisc(Long id);
}

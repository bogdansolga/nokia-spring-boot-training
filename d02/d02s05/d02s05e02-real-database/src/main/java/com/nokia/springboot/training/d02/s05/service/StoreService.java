package com.nokia.springboot.training.d02.s05.service;

import com.nokia.springboot.training.d02.s05.dto.StoreDTO;
import com.nokia.springboot.training.d02.s05.exceptions.NotFoundException;
import com.nokia.springboot.training.d02.s05.model.Store;
import com.nokia.springboot.training.d02.s05.model.StoreSection;
import com.nokia.springboot.training.d02.s05.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(final StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public StoreDTO get(final int id) {
        final Store store =
                Optional.ofNullable(storeRepository.findOne(id))
                        .orElseThrow(() ->
                        new NotFoundException("There's no store with the ID " + id));

        return convertStore().apply(store);
    }

    private Function<Store, StoreDTO> convertStore() {
        return store -> new StoreDTO(
                store.getId(),
                store.getName(),
                store.getStoreSections()
                     .stream()
                     .map(StoreSection::getSectionName)
                     .collect(Collectors.toSet())
        );
    }

    public Set<StoreDTO> getAll() {
        return null;
    }
}

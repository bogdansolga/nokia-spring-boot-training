package com.nokia.springboot.training.d02.s05.service;

import com.nokia.springboot.training.d02.s05.dto.SectionDTO;
import com.nokia.springboot.training.d02.s05.exceptions.NotFoundException;
import com.nokia.springboot.training.d02.s05.model.Product;
import com.nokia.springboot.training.d02.s05.model.StoreSection;
import com.nokia.springboot.training.d02.s05.repository.SectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SectionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SectionService.class);

    private final SectionRepository sectionRepository;

    @Autowired
    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Transactional(
            readOnly = true,
            propagation = Propagation.SUPPORTS
    )
    public SectionDTO get(int id) {
        final StoreSection storeSection =
                Optional.ofNullable(sectionRepository.findOne(id))
                        .orElseThrow(() -> new NotFoundException("No section with the ID " + id));

        return storeSectionConverter().apply(storeSection);
    }

    private Function<StoreSection, SectionDTO> storeSectionConverter() {
        return storeSection -> new SectionDTO(
                storeSection.getId(),
                storeSection.getSectionName(),
                storeSection.getStore().getName(),
                storeSection.getProducts()
                            .stream()
                            .map(Product::getName)
                            .collect(Collectors.toList())
        );
    }
}

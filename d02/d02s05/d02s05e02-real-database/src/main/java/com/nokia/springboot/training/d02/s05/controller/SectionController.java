package com.nokia.springboot.training.d02.s05.controller;

import com.nokia.springboot.training.d02.s05.dto.SectionDTO;
import com.nokia.springboot.training.d02.s05.profiling.MemoryProfiling;
import com.nokia.springboot.training.d02.s05.profiling.Profiled;
import com.nokia.springboot.training.d02.s05.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = "/section"
)
public class SectionController {

    private final SectionService sectionService;

    @Autowired
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @RequestMapping(
            path = "/{id}",
            method = RequestMethod.GET
    )
    @Profiled
    @MemoryProfiling
    public SectionDTO getSection(@PathVariable final int id) {
        return sectionService.get(id);
    }
}

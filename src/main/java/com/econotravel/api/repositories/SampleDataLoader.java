package com.econotravel.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class SampleDataLoader {

    private ExperienceRepository experienceRepository;

    @Autowired
    public SampleDataLoader(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @PostConstruct
    public void loadSampleData() {
        experienceRepository.saveAll(List.of(

                new Experience("Paseo globo", "gfgdfgd", 250.00, 5, "tp", "gfdfgdfg"),
                new Experience("Paseo Bici", "gfgdfgd", 250.00, 5, "tp", "gfdfgdfg")
        ));

    }
}
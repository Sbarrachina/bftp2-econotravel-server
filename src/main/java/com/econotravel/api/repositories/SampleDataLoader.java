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

                new Experience("Paseo por el Montseny", 300, 5),
                new Experience("Visita a la sagrada familia", 300, 4),
                new Experience("Descubre la Barcelona Modernista de noche", 200, 4),
                new Experience("Del huerto a la mesa", 145, 3),
                new Experience("Arte en la montaña sagrada", 125, 2)));


    }
}
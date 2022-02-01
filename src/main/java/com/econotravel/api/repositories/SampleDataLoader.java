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
                new Experience("Paseo","bici",250,5,"tp","montaña"),



                new Experience("Un mago de Terramar", "Ursula K. Leguin", "Fantasy"),
                new Experience("Los desposeídos", "Ursula K. Leguin", "Fantasy"),
                new Experience("Lean Software Development", "Mary Poppendieck", "Software"),
                new Experience("Women, Race and Class", "Angela Y. Davis", "Essay"),
                new Experience("Object Design", "Rebecca Wirfs-Brock", "Software")
        ));
    }
}
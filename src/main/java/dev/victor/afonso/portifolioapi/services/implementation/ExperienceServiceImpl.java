package dev.victor.afonso.portifolioapi.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.victor.afonso.portifolioapi.models.Experience;
import dev.victor.afonso.portifolioapi.repositories.ExperienceRepository;
import dev.victor.afonso.portifolioapi.services.ExperienceService;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;

    ExperienceServiceImpl(ExperienceRepository experienceRepository){
        this.experienceRepository = experienceRepository;
    }

    @Override
    public List<Experience> findAllUserExperience(List<String> ids) {
        return this.experienceRepository.findAllByIdIn(ids);
    }
    
}

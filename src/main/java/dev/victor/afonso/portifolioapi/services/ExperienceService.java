package dev.victor.afonso.portifolioapi.services;

import java.util.List;

import dev.victor.afonso.portifolioapi.models.Experience;

public interface ExperienceService {
    
    List<Experience> findAllUserExperience(List<String> ids);
}

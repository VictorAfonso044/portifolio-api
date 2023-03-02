package dev.victor.afonso.portifolioapi.dataFetchers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.victor.afonso.portifolioapi.models.Experience;
import dev.victor.afonso.portifolioapi.models.Person;
import dev.victor.afonso.portifolioapi.services.ExperienceService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ExperiencesDataFetcher implements DataFetcher<List<Experience>> {

    private final ExperienceService experienceService;

    ExperiencesDataFetcher(ExperienceService experienceService){
        this.experienceService = experienceService;
    }
    
    @Override
    public List<Experience> get(DataFetchingEnvironment environment) throws Exception {
        Person person = environment.getSource();
        List<String> experienceIds = new ArrayList<>();
        if(person != null){
            experienceIds = person.getExperiencesIds();
        }
        return this.experienceService.findAllUserExperience(experienceIds);
    }
}

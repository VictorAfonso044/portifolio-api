package dev.victor.afonso.portifolioapi.dataFetchers;

import java.util.List;

import org.springframework.stereotype.Component;

import dev.victor.afonso.portifolioapi.models.Person;
import dev.victor.afonso.portifolioapi.services.PersonService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllPersonsDataFetcher implements DataFetcher<List<Person>>{
    
    private final PersonService personService;

    AllPersonsDataFetcher(PersonService personService){
        this.personService = personService;
    }

    @Override
    public List<Person> get(DataFetchingEnvironment environment) throws Exception {
        return this.personService.findAllUsers();
    }
}

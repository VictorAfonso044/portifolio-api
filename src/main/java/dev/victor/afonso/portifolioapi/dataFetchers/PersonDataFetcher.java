package dev.victor.afonso.portifolioapi.dataFetchers;

import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import dev.victor.afonso.portifolioapi.models.Person;
import dev.victor.afonso.portifolioapi.services.PersonService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class PersonDataFetcher implements DataFetcher<Person> {

    private final PersonService personService;

    PersonDataFetcher(PersonService personService){
        this.personService = personService;
    }

    @Override
    public Person get(DataFetchingEnvironment environment) throws Exception {
        Map<String, Object> args = environment.getArguments();
        return this.personService.findOneById(new ObjectId(String.valueOf(args.get("id"))));
    }
}

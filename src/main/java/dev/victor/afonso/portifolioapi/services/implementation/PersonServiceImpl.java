package dev.victor.afonso.portifolioapi.services.implementation;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import dev.victor.afonso.portifolioapi.models.Person;
import dev.victor.afonso.portifolioapi.repositories.PersonRepository;
import dev.victor.afonso.portifolioapi.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
    
    private final PersonRepository personRepository;

    PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAllUsers() {
        return (List<Person>) this.personRepository.findAll();
    }

    @Override
    public Person findOneById(ObjectId id) {
        return this.personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> findByIdIn(List<String> ids) {
        return this.personRepository.findByIdIn(ids);
    }
}

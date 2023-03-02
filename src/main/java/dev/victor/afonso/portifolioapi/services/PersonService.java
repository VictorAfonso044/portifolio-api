package dev.victor.afonso.portifolioapi.services;

import java.util.List;

import org.bson.types.ObjectId;

import dev.victor.afonso.portifolioapi.models.Person;

public interface PersonService {
    
    public List<Person> findAllUsers();

    public Person findOneById(ObjectId id);

    public List<Person> findByIdIn(List<String> ids);
}

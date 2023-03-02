package dev.victor.afonso.portifolioapi.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

import dev.victor.afonso.portifolioapi.models.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, ObjectId> {

    List<Person> findByIdIn(List<String> ids);
}

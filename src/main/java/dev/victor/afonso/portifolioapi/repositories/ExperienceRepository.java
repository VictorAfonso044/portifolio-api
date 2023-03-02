package dev.victor.afonso.portifolioapi.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

import dev.victor.afonso.portifolioapi.models.Experience;

public interface ExperienceRepository extends PagingAndSortingRepository<Experience, ObjectId> {
    List<Experience> findAllByIdIn(List<String> ids);
}

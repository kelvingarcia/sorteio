package com.kelvin.sorteio.repository;

import com.kelvin.sorteio.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {
}

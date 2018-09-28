package com.edmunds.repository;

import com.edmunds.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by alekseymorozov on 9/28/18.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {

    Optional<Person> findPersonByEmail(String email);
}

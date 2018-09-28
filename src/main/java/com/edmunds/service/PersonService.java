package com.edmunds.service;

import com.edmunds.repository.PersonRepository;
import com.edmunds.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by alekseymorozov on 9/28/18.
 */
@Service
public final class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findPersons(){

        List<Person> people = new ArrayList<>();

        personRepository.findAll()
                .forEach(people::add);

        return people;
    }

    public Optional<Person> findPersonByEmail(String email){
        return personRepository.findPersonByEmail(email);
    }

    public Person createPerson(Person person) {

       return personRepository.save(person);
    }

    public Optional<Person> findPerson(Integer id) {


        return personRepository.findById(id);
    }

    public void updatePerson(Person person, Integer id) {
        person.setId(id);
        personRepository.save(person);

    }

    public void deletePerson(Integer id){
        personRepository.deleteById(id);
    }
}

package com.edmunds.controller;

import com.edmunds.model.Person;
import com.edmunds.service.PersonService;
import com.edmunds.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alekseymorozov on 9/28/18.
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping("/")
    public String home(){
        return "hi, I am a very \"person\"al web service. " +
                "My users are able to search for Person records by ID or email.";
    }

    @GetMapping("/persons")
    public List<Person> findAll() {

        List<Person> persons = personService.findPersons();

        if (! persons.isEmpty()) {
            return persons;
        }
        else {
            throw new PersonNotFoundException( "no personal records are found" );
        }
    }


    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }


    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public Person searchPersonById(@PathVariable("id") Integer id){

        return personService.findPerson(id)
                .orElseThrow( () ->
                        new PersonNotFoundException("id: " + id));
    }


    @GetMapping("/person/email/{email}")
    public Person getByEmail(@PathVariable String email){

        return personService.findPersonByEmail(email)
                .orElseThrow(() ->
                        new PersonNotFoundException("email: " + email));
    }


    @PutMapping("/person/{id}")
    public void updatePerson(@PathVariable Integer id, @RequestBody Person person){
        personService.updatePerson(person, id);
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable Integer id){
        personService.deletePerson(id);
    }
}

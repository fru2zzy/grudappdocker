package com.example.grudappdocker.service;


import com.example.grudappdocker.exception.PersonNotFoundException;
import com.example.grudappdocker.model.Person;
import com.example.grudappdocker.repository.PersonRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepo personRepo;

    public List<Person> findAll() {
        return personRepo.findAll();
    }

    public Person findById(@PathVariable Long id) throws PersonNotFoundException {
        return personRepo.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    public Person save(@RequestBody Person person) {
        return personRepo.save(person);
    }

    public Person update(Long id, Person person) throws PersonNotFoundException {
        Person personFromDb = personRepo.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        if (person != null) {
            personFromDb.setName(person.getName());
        }
        return personRepo.save(personFromDb);
    }

    public Person deleteById(Long id) throws PersonNotFoundException {
        Person personFromDb = personRepo.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        personRepo.deleteById(id);
        return personFromDb;
    }
}
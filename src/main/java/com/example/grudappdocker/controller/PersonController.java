package com.example.grudappdocker.controller;


import com.example.grudappdocker.exception.PersonNotFoundException;

import com.example.grudappdocker.model.Person;
import com.example.grudappdocker.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/findAll")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/byId/{id}")
    public Person findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @PostMapping("/save")
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping("/update/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person) throws PersonNotFoundException {
        return personService.update(id, person);
    }

    @DeleteMapping("/delete/{id}")
    public Person deleteById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.deleteById(id);
    }
}
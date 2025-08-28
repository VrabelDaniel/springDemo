package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person findById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePerson(@RequestBody Person person) {
        personService.savePerson(person);
    }

    //example: /api/person/special-find-by-id?id=1
    @GetMapping("special-find-by-id")
    @ResponseStatus(HttpStatus.OK)
    public Person specialFindById(@RequestParam Long id) {
        return personService.findById(id);
    }
}

package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.model.PersonCreationDto;
import com.example.demo.model.PersonDto;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDto findById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePerson(@RequestBody PersonCreationDto person) {
        personService.savePerson(person);
    }

    //example: /api/person/special-find-by-id?id=1
    @GetMapping("special-find-by-id")
    @ResponseStatus(HttpStatus.OK)
    public PersonDto specialFindById(@RequestParam Long id) {
        return personService.findById(id);
    }

    @GetMapping("/find-by-name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDto> findByName(@PathVariable String name) {
        return personService.findByName(name);
    }

    @GetMapping("/find-by-name-optional/{name}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDto findByNameOptional(@PathVariable String name) {
        return personService.findByNameOptional(name);
    }

    @GetMapping("/find-all-by-name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDto> findAllByName(@PathVariable String name) {
        return personService.findAllByName(name);
    }
}

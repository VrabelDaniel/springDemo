package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.model.PersonDto;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public void savePerson(@RequestBody Person person) {
        personService.savePerson(person);
    }

    //example: /api/person/special-find-by-id?id=1
    @GetMapping("special-find-by-id")
    @ResponseStatus(HttpStatus.OK)
    public PersonDto specialFindById(@RequestParam Long id) {
        return personService.findById(id);
    }
}

package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    //vm option: -Dspring.profiles.active=dev
    @Value("${custom.category:fakeHuman}")
    private String category;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow();
    }

    public void savePerson(Person person) {
        person.setCategory(category);
        personRepository.save(person);
    }
}

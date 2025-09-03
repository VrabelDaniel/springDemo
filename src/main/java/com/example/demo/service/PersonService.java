package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.model.PersonDto;
import com.example.demo.model.PersonMapper;
import com.example.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    //vm option: -Dspring.profiles.active=dev
    @Value("${custom.category:fakeHuman}")
    private String category;

    public PersonDto findById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow();
        return personMapper.entityToDto(person);
    }

    public void savePerson(Person person) {
        person.setCategory(category);
        personRepository.save(person);
    }
}

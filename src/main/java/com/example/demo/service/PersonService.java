package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.model.PersonCreationDto;
import com.example.demo.model.PersonDto;
import com.example.demo.model.PersonMapper;
import com.example.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
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

    public void savePerson(PersonCreationDto dto) {
        Person person = personMapper.creationDtoToEntity(dto);
        person.setCategory(category);
        log.info("Saving person: {}", person);
        personRepository.save(person);
    }

    public List<PersonDto> findByName(String name) {
        List<Person> foundPeople = new ArrayList<>();

        foundPeople.add(personRepository.findByName(name));
        foundPeople.add(personRepository.findByNameJPQL(name));
        foundPeople.add(personRepository.findByNameNativeQuery(name));

        return personMapper.entitiesToDtos(foundPeople);
    }

    public PersonDto findByNameOptional(String name) {
        Person person = personRepository.findByNameOptional(name)
                .orElseThrow();
//                .orElse(new Person(0L, "No name", 0, "No category"));

        return personMapper.entityToDto(person);

//        Optional<Person> optionalPerson = personRepository.findByNameOptional(name);
//        if (optionalPerson.isEmpty()) {
//            log.warn("Person not found with name: {}", name);
//            return new PersonDto(0L, "No name", 0);
//        } else {
//            return personMapper.entityToDto(optionalPerson.get());
//        }
    }

    public List<PersonDto> findAllByName(String name) {
        List<Person> foundPeople = personRepository.findAllByName(name);
        return personMapper.entitiesToDtos(foundPeople);
    }
}

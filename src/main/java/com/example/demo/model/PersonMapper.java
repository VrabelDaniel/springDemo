package com.example.demo.model;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDto entityToDto(Person person);

    Person creationDtoToEntity(PersonCreationDto dto);

    List<PersonDto> entitiesToDtos(List<Person> personList);
}

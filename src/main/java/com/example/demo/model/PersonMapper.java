package com.example.demo.model;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDto entityToDto(Person person);

    Person dtoToEntity(PersonDto personDto);
}

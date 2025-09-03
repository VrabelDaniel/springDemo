package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDto {
    private Long id;
    private String name;
    private Integer age;
//    private String category;
}

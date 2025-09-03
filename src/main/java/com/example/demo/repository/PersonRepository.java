package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByName(String name);

    @Query("SELECT p FROM Person p WHERE p.name = :name")
    Person findByNameJPQL(@Param("name") String name);

    @Query(value = "SELECT * FROM Demo.Person WHERE name = :name", nativeQuery = true)
    Person findByNameNativeQuery(String name);

    @Query("SELECT p FROM Person p WHERE p.name = :name")
    Optional<Person> findByNameOptional(String name);

    @Query("SELECT p FROM Person p WHERE p.name = :name")
    List<Person> findAllByName(String name);
}

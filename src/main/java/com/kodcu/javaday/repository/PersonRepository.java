package com.kodcu.javaday.repository;

import com.kodcu.javaday.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
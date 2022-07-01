package com.paritosh.learning.springdatabase.jpa;

import com.paritosh.learning.springdatabase.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {
}

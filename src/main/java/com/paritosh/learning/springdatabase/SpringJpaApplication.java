package com.paritosh.learning.springdatabase;

import com.paritosh.learning.springdatabase.entity.Person;
import com.paritosh.learning.springdatabase.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(SpringJpaApplication.class);

	@Autowired
	PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {

		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 personJpaRepository.addPerson(new Person("John","New York", new Date())) ;
		logger.info("Person 10001 -> {} ",personJpaRepository.findPersonById(1));
		personJpaRepository.deleteById(10002);

		logger.info("All data {} ",personJpaRepository.findAll());
//		logger.info("Added persion -> {}", personJdbcDAO.updatePerson(new Person(10001,"Amit","New Jersey", new Date())) );
	}
}

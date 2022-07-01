package com.paritosh.learning.springdatabase;

import com.paritosh.learning.springdatabase.entity.Person;
import com.paritosh.learning.springdatabase.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringdatabaseApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(SpringdatabaseApplication.class);

	@Autowired
	PersonJdbcDAO personJdbcDAO;

	public static void main(String[] args) {

		SpringApplication.run(SpringdatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Persons -> {} ",personJdbcDAO.findAll());
		logger.info("Person 10001 -> {} ",personJdbcDAO.findById(10001));
		logger.info("Person 10002 deleted -> number of rows deleted {} ",personJdbcDAO.deleteById(10002));
		logger.info("Added persion -> {}", personJdbcDAO.addPerson(new Person(10004,"John","New York", new Date())) );
		logger.info("Added persion -> {}", personJdbcDAO.updatePerson(new Person(10001,"Amit","New Jersey", new Date())) );
	}
}

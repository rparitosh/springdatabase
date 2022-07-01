package com.paritosh.learning.springdatabase.jdbc;

import com.paritosh.learning.springdatabase.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll(){
        return jdbcTemplate.query("Select * from person",new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person findById(int id){
        return jdbcTemplate.queryForObject("Select * from person where id = ? ",
                new BeanPropertyRowMapper<Person>(Person.class),new Object[] {id});
    }

    public int deleteById(int id){
        return jdbcTemplate.update("delete from person where id = ?", new Object[] {id});
    }

    public int addPerson(Person person){
        return jdbcTemplate.update("insert into Person (id, name, location, birth_date) values (?,?,?,?)",
                new Object[] {person.getId(), person.getName(), person.getLocation(),
                new Timestamp(person.getBirthDate().getTime())});
    }

    public int updatePerson(Person person){
        return jdbcTemplate.update("update person set name= ?, location = ?, birth_date = ? where id = ?",
                new Object[] { person.getName(), person.getLocation(),
                new Timestamp(person.getBirthDate().getTime()), person.getId()});
    }
}

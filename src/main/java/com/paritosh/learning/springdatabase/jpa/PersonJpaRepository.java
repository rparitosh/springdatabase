package com.paritosh.learning.springdatabase.jpa;

import com.paritosh.learning.springdatabase.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findPersonById(int id){

        return entityManager.find(Person.class,id);

    }

    public void addPerson(Person person){
        entityManager.persist(person);

    }

    public void remove(Person person){
        entityManager.remove(entityManager.contains(person)? person: entityManager.merge(person));
    }

    public void deleteById(int id){
        Person person= findPersonById(id);

        if (person == null){
            throw new RuntimeException("Cannot find person to be deleted");
        }
        entityManager.remove(person);

    }

    public List<Person> findAll(){
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }
}

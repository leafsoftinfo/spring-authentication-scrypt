package com.project.security.scrypt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.security.scrypt.model.Person;


/**
 * @author Yvau
 *
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

    public Person findByUsername(String username);

}

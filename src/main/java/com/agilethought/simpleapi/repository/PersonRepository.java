package com.agilethought.simpleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agilethought.simpleapi.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	Person findByIdPerson(Integer id);
}

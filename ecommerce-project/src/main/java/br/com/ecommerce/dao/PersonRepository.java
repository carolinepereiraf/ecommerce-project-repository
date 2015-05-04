package br.com.ecommerce.dao;

import br.com.ecommerce.domain.Person;

import org.springframework.data.neo4j.repository.GraphRepository;

public interface PersonRepository extends GraphRepository<Person>{

	// start person=node:Person(id={0}) return person
    Person findById(Long id);

}

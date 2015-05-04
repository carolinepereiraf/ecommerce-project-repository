package br.com.ecommerce.services;

import org.springframework.data.neo4j.conversion.Result;

import br.com.ecommerce.domain.Person;

public interface PersonService {
	
	Person create(Person person);

	void delete(Person person);

	Person findById(long id);

	Result<Person> findAll();
}

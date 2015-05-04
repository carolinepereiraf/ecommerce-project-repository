package br.com.ecommerce.services;

import java.util.List;

import br.com.ecommerce.domain.Person;

public interface PersonService {
	
	Person create(Person person);

	void delete(Person person);
	
	Person findByPersonId(long id);

	List<Person> findAll();
	
	List<Person> findAllLimitBy(int limit);
	
}

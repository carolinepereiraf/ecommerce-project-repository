package br.com.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.stereotype.Service;

import br.com.ecommerce.dao.PersonRepository;
import br.com.ecommerce.domain.Person;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person create(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void delete(Person person) {
		personRepository.delete(person);
	}

	@Override
	public Person findById(long id) {
		return personRepository.findById(id);
	}

	@Override
	public Result<Person> findAll() {
		return personRepository.findAll();
	}

}

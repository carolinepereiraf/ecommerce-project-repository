package br.com.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Person findByPersonId(long id){
		return personRepository.getPersonByPersonId(id);
	}

	@Override
	public List<Person> findAll() {
		return personRepository.getAllPeople();
	}
	
	@Override
	public List<Person> findAllLimitBy(int limit) {
		return personRepository.getAllPeopleLimitBy(limit);
	}

}

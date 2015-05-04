package br.com.ecommerce.services;

import java.util.List;

import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;

import br.com.ecommerce.dao.PersonRepository;
import br.com.ecommerce.domain.Person;
import br.com.ecommerce.domain.Product;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private Neo4jTemplate template;

	@Override
	public Person create(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void delete(Person person) {
		personRepository.delete(person);
	}

	@Override
	public Person findByPersonId(long id) {
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

	@Override
	public void addViewedProduct(Person person, Product product) {
		GraphDatabase gdb = template.getGraphDatabase();
		Transaction tx = gdb.beginTx();
		try {
			person.addViewedProduct(product);
			tx.success();
		} finally {
			tx.close();
		}
		personRepository.save(person);
	}

	@Override
	public void addCartProduct(Person person, Product product) {
		GraphDatabase gdb = template.getGraphDatabase();
		Transaction tx = gdb.beginTx();
		try {
			person.addCartProduct(product);
			tx.success();
		} finally {
			tx.close();
		}
		personRepository.save(person);
	}

	@Override
	public void addBoughtProduct(Person person, Product product) {
		GraphDatabase gdb = template.getGraphDatabase();
		Transaction tx = gdb.beginTx();
		try {
			person.addBoughtProduct(product);
			tx.success();
		} finally {
			tx.close();
		}
		personRepository.save(person);
	}

}

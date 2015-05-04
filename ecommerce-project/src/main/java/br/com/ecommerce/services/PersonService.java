package br.com.ecommerce.services;

import java.util.List;

import br.com.ecommerce.domain.Person;
import br.com.ecommerce.domain.Product;


public interface PersonService {
	
	Person create(Person person);

	void delete(Person person);
	
	Person findByPersonId(long id);

	List<Person> findAll();
	
	List<Person> findAllLimitBy(int limit);
	
	void addViewedProduct(Person person, Product product);
	
	void addCartProduct(Person person, Product product);
	
	void addBoughtProduct(Person person, Product product);
	
}

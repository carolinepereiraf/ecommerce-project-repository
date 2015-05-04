package br.com.commerce.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.neo4j.conversion.Result;

import br.com.ecommerce.domain.Person;
import br.com.ecommerce.services.PersonService;

/**
 * Operations of PeopleResource WebService using PersonService
 *
 */
public class PersonUtil {

	private ApplicationContext context;
	private PersonService service;

	public PersonUtil() {
		context = new ClassPathXmlApplicationContext("person.xml");
		service = (PersonService) context.getBean("personService");
	}

	/**
	 * Create person and persists
	 * 
	 * @param id
	 * @param name
	 * @param email
	 * @return
	 */
	public Person createPerson(long id, String name, String email) {
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		person.setEmail(email);
		return service.create(person);
	}

	/**
	 * Find person by id
	 * 
	 * @param id
	 * @return
	 */
	public Person getOnePersonById(long id) {
		return service.findById(id);
	}

	/**
	 * Delete person by id
	 * 
	 * @param id
	 */
	public boolean deletePerson(long id) {
		Person person = getOnePersonById(id);
		if (person != null) {
			service.delete(person);
			return true;
		} else {
			return false;
		}
	}

	public List<Person> listAll() {
		List<Person> list = new ArrayList<Person>();
		Result<Person> result = service.findAll();
		Iterator<Person> iterator = result.iterator();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}
}

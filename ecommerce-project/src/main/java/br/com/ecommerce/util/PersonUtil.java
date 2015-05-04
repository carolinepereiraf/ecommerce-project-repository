package br.com.ecommerce.util;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		Person person = getOnePersonById(id);
		if(person != null){
			return null;
		}
		person = new Person();
		person.setPersonId(id);
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
		return service.findByPersonId(id);
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
		List<Person> list = service.findAll();
		return list;
	}
	
	public List<Person> listAllLimitBy(int limit) {
		List<Person> list = service.findAllLimitBy(limit);
		return list;
	}
}

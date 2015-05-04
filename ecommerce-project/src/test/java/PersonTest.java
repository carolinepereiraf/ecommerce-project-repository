import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.neo4j.conversion.Result;

import br.com.ecommerce.domain.Person;
import br.com.ecommerce.services.PersonService;

public class PersonTest {

	public static void main(String[] args) {
		System.out.println("PersonTest.main()");

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"person.xml");
		System.out.println("Context created");

		PersonService service = (PersonService) context
				.getBean("personService");
		System.out.println("Person Service created");

		System.out.println("******** Creating person: ***********");
		Person person = createPerson(2, "Caroline", "carolinepereiraf@gmail.com");
		createPerson(service, person);
		System.out.println("Person created successfully.");

		System.out.println("******** Getting person by id: ***********");
		person = getOnePersonById(service, 1);
		System.out.println("Person found: " + person);

		/*
		 * System.out.println("********Removing person: ***********");
		 * deletePerson(service, person); System.out.println("Person removed: "
		 * + person);
		 * 
		 * System.out.println("******** Getting removed person: ***********");
		 * person = service.findById(1); System.out.println("Person found: " +
		 * person);
		 */

	//	getAllPeople(service);
	}

	private static Person createPerson(PersonService service, Person person) {
		return service.create(person);
	}

	private static void deletePerson(PersonService service, Person person) {
		service.delete(person);
	}

	private static Person getOnePersonById(PersonService service, int id) {
		return service.findById(id);
	}

	private static void getAllPeople(PersonService service) {
		System.out.println("PersonTest.getAllPeople()");
		Result<Person> result = service.findAll();
		System.out.println("result " + result);
		Iterator<Person> iterator = result.iterator();
		System.out.println("iterator: " + iterator);

		while (iterator.hasNext()) {
			System.out.println("hasnext");
			Person p = iterator.next();
			System.out.println("person: " + p);
			System.out.println(p.getId());
		}
	}

	private static Person createPerson(long id, String name, String email) {
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		person.setEmail(email);
		return person;
	}
}

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.ecommerce.domain.Person;
import br.com.ecommerce.services.PersonService;

/**
 * Classe para testar as principais funcionalidades para a Entity Person:
 * inserção, consulta, remoção e listar todos com limite.
 * 
 * Criada para ser um teste rápido, para executar as Java Application.
 *
 */
@SuppressWarnings("unused")
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

		Person person = createPerson(1, "pedro", "pedro@gmail.com");
		createPerson(service, person);
		System.out.println("Person created successfully.");

		person = createPerson(2, "carol", "carol@gmail.com");
		createPerson(service, person);
		System.out.println("Person created successfully.");

		System.out.println("******** Getting person by personId: ***********");

		person = getOnePersonById(service, 2);
		System.out.println("Person: " + person.getId() + " "
				+ person.getPersonId() + " " + person.getName() + " "
				+ person.getEmail());

		person = getOnePersonById(service, 1);
		System.out.println("Person: " + person.getId() + " "
				+ person.getPersonId() + " " + person.getName() + " "
				+ person.getEmail());

		System.out.println("********Removing person: ***********");
		person = getOnePersonById(service, 2);
		deletePerson(service, person);
		System.out.println("Person removed: " + person);

		System.out.println("******** Getting removed person: ***********");
		person = getOnePersonById(service, 2);
		System.out.println("Person found: " + person);

		System.out.println("******* Find all ********");
		getAllPeople(service);

		System.out.println("******* Find all limit by ********");
		getAllPeopleLimitBy(service, 1);
	}

	/**
	 * Deleta Person especificada
	 * @param service
	 * @param person
	 */
	private static void deletePerson(PersonService service, Person person) {
		service.delete(person);
	}

	/**
	 * Retorna Person para ID espedificado
	 * @param service
	 * @param id
	 * @return
	 */
	private static Person getOnePersonById(PersonService service, int id) {
		return service.findByPersonId(id);
	}

	/**
	 * Retorna lista completa de Person
	 * @param service
	 */
	private static void getAllPeople(PersonService service) {
		System.out.println("PersonTest.getAllPeople()");
		List<Person> result = service.findAll();
		System.out.println("Result: " + result.size());

		for (Person person : result) {
			System.out.println("Person: " + person.getId() + " "
					+ person.getPersonId() + " " + person.getName() + " "
					+ person.getEmail());
		}

	}

	/**
	 * Retorna lista de todos os Person até determinado limite
	 * @param service
	 * @param limit
	 */
	private static void getAllPeopleLimitBy(PersonService service, int limit) {
		List<Person> result = service.findAllLimitBy(limit);
		System.out.println("Result: " + result.size());

		for (Person person : result) {
			System.out.println("Person: " + person.getId() + " "
					+ person.getPersonId() + " " + person.getName() + " "
					+ person.getEmail());
		}

	}

	/**
	 * Monta objeto Person com os parametros especificados
	 * @param id
	 * @param name
	 * @param email
	 * @return
	 */
	private static Person createPerson(long id, String name, String email) {
		Person person = new Person();
		person.setPersonId(id);
		person.setName(name);
		person.setEmail(email);
		return person;
	}
	
	/**
	 * Insere Person no BD
	 * @param service
	 * @param person
	 * @return
	 */
	private static Person createPerson(PersonService service, Person person) {
		return service.create(person);
	}
}

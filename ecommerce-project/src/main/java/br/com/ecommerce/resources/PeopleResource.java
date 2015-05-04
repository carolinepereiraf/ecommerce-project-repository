package br.com.ecommerce.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;

import br.com.ecommerce.domain.Person;
import br.com.ecommerce.util.PersonUtil;

@Path("/people")
public class PeopleResource {

	/**
	 * Log
	 */
	private static Logger log = Logger.getLogger(PeopleResource.class);

	private static PersonUtil personUtil = new PersonUtil();

	/**
	 * Retorna todas as pessoas existentes com um limite
	 * 
	 * @param limit
	 * @return
	 */
	@GET
	@Produces("application/json")
	public List<Person> getPeople(@QueryParam("limit") int limit) {

		if (limit == 0) {
			log.info("Returning all people");
			return personUtil.listAll();
		}

		log.info("Returning people, limit = " + limit);
		return personUtil.listAllLimitBy(limit);
	}

	/**
	 * Busca pessoa com ID especifico
	 * 
	 * @param id
	 * @return
	 */
	@Path("{personId}")
	@GET
	@Produces("application/json")
	public Person getPerson(@PathParam("personId") int id) {
		Person person = personUtil.getOnePersonById(id);
		if (person != null) {
			log.info("Returning person " + person.getName());
		} else {
			log.info("No person found for ID " + id);
		}
		return person;
	}

	/**
	 * Adiciona uma pessoa com os parametros especificados
	 * 
	 * @param personId
	 * @param email
	 * @param name
	 * @return
	 */
	@POST
	@Consumes("text/xml")
	@Produces("application/json")
	public String addPerson(@FormParam("personId") long personId,
			@FormParam("email") String email, @FormParam("name") String name) {

		Person person = personUtil.createPerson(personId, name, email);
		String message = null;
		if (person == null) {
			log.info("A person with this personId already exists.");
			message = "Já existe uma pessoa para este ID.";
		} else {
			log.info("Person " + person.getName() + " successfully added.");
			message = person.getName() + " adicionado com sucesso.";
		}
		return message;
	}

	/**
	 * Deleta uma pessoa de ID especifico
	 * 
	 * @param id
	 * @return
	 */
	@Path("{personId}")
	@DELETE
	@Produces("application/json")
	public String removePerson(@PathParam("personId") int id) {
		boolean deleted = personUtil.deletePerson(id);
		if (deleted) {
			log.info("Person successfully removed.");
		} else {
			log.info("Person could not be removed");
		}

		String message = "Pessoa removida com sucesso.";
		return message;
	}

}

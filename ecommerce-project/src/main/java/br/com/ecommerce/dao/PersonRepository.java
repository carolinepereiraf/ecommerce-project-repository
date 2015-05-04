package br.com.ecommerce.dao;

import java.util.List;

import br.com.ecommerce.domain.Person;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface PersonRepository extends GraphRepository<Person> {

	@Query("match (p:Person) return p")
	List<Person> getAllPeople();
	
	@Query("match (p:Person) return p limit {0}")
	List<Person> getAllPeopleLimitBy(int limit);
	
	@Query("match (p:Person) where p.personId = {0} return p")
	Person getPersonByPersonId(long personId);

}

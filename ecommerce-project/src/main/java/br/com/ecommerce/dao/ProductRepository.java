package br.com.ecommerce.dao;

import org.springframework.data.neo4j.repository.GraphRepository;

import br.com.ecommerce.domain.Product;


public interface ProductRepository extends GraphRepository<Product>{

	// start person=node:Person(id={0}) return person
    Product findById(Long id);
}

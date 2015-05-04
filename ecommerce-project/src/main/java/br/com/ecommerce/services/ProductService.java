package br.com.ecommerce.services;

import org.springframework.data.neo4j.conversion.Result;

import br.com.ecommerce.domain.Product;

public interface ProductService {
	
	Product create(Product product);
	
	void delete(Product product);
	
	Product findById(long id);
	
	Result<Product> findAll();
}

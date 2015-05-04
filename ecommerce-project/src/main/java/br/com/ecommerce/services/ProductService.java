package br.com.ecommerce.services;

import java.util.List;

import br.com.ecommerce.domain.Product;

public interface ProductService {
	
	Product create(Product product);
	
	void delete(Product product);
	
	Product findByProductId(long id);
	
	List<Product> findAll();
	
	List<Product> findAllLimitBy(int limit);
}

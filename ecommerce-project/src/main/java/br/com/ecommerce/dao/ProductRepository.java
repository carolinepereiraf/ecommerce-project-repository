package br.com.ecommerce.dao;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import br.com.ecommerce.domain.Product;


public interface ProductRepository extends GraphRepository<Product>{

	@Query("match (p:Product) return p")
	List<Product> getAllProducts();
	
	@Query("match (p:Product) return p limit {0}")
	List<Product> getAllProductsLimitBy(int limit);
	
	@Query("match (p:Product) where p.productId = {0} return p")
	Product getProductByProductId(long productId);
}

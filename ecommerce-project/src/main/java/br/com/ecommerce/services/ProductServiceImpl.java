package br.com.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.stereotype.Service;

import br.com.ecommerce.dao.ProductRepository;
import br.com.ecommerce.domain.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product create(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}

	@Override
	public Product findById(long id) {
		return productRepository.findById(id);
	}

	@Override
	public Result<Product> findAll() {
		return productRepository.findAll();
	}

}

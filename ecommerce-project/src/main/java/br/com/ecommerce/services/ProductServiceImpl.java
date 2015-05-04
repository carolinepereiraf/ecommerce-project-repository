package br.com.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Product findByProductId(long id) {
		return productRepository.getProductByProductId(id);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.getAllProducts();
	}

	@Override
	public List<Product> findAllLimitBy(int limit) {
		return productRepository.getAllProductsLimitBy(limit);
	}

	

}

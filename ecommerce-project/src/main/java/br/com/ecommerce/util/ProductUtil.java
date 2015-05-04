package br.com.ecommerce.util;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.ecommerce.domain.Product;
import br.com.ecommerce.services.ProductService;

/**
 * Operations of ProductsResource WebService using ProductService
 *
 */
public class ProductUtil {

	private ApplicationContext context;
	private ProductService productService;
	
	public ProductUtil() {
		context = new ClassPathXmlApplicationContext("product.xml");
		productService = (ProductService) context.getBean("productService");
	}
	
	/**
	 * Create product and persists
	 * @param id
	 * @param name
	 * @param price
	 * @return
	 */
	public Product createProduct(long id, String name, Double price) {
		Product product = new Product();
		product.setProductId(id);
		product.setName(name);
		product.setPrice(price);
		return productService.create(product);
	}
	
	/**
	 * Find product by id
	 * 
	 * @param id
	 * @return
	 */
	public Product getOneProductById(long id) {
		return productService.findByProductId(id);
	}
	
	/**
	 * Delete product by id
	 * 
	 * @param id
	 */
	public boolean deleteProduct(long id) {
		Product product = getOneProductById(id);
		if (product != null) {
			productService.delete(product);
			return true;
		} else {
			return false;
		}
	}
	
	public List<Product> listAll() {
		List<Product> list = productService.findAll();
		return list;
	}
	
	public List<Product> listAllLimitBy(int limit) {
		List<Product> list = productService.findAllLimitBy(limit);
		return list;
	}
}

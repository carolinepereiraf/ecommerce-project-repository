package br.com.ecommerce.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.neo4j.conversion.Result;

import br.com.ecommerce.domain.Product;
import br.com.ecommerce.services.ProductService;

/**
 * Operations of ProductsResource WebService using ProductService
 *
 */
public class ProductUtil {

	private ApplicationContext context;
	private ProductService service;
	
	public ProductUtil() {
		context = new ClassPathXmlApplicationContext("product.xml");
		service = (ProductService) context.getBean("productService");
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
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		return service.create(product);
	}
	
	/**
	 * Find product by id
	 * 
	 * @param id
	 * @return
	 */
	public Product getOneProductById(long id) {
		return service.findById(id);
	}
	
	/**
	 * Delete product by id
	 * 
	 * @param id
	 */
	public boolean deleteProduct(long id) {
		Product product = getOneProductById(id);
		if (product != null) {
			service.delete(product);
			return true;
		} else {
			return false;
		}
	}
	
	public List<Product> listAll() {
		List<Product> list = new ArrayList<Product>();
		Result<Product> result = service.findAll();
		Iterator<Product> iterator = result.iterator();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}
}

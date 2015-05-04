import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.ecommerce.domain.Person;
import br.com.ecommerce.domain.Product;
import br.com.ecommerce.services.PersonService;
import br.com.ecommerce.services.ProductService;

public class GeneralTest {

	public static void main(String[] args) {
		System.out.println("GeneralTest.main()");

		// Criando contextos

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"person.xml");
		PersonService personService = (PersonService) context
				.getBean("personService");
		System.out.println("PersonService created");

		ProductService productService = (ProductService) context
				.getBean("productService");
		System.out.println("ProductService created");

		// Criando pessoa
		// Person person = createPerson(personService, 1, "Caroline",
		// "caroline@gmail.com");
		// System.out.println("Person created: " + person.getName());

		Person person = personService.findByPersonId(1);
		System.out.println("Produtos: " + person.getViewedProducts());

		// Criando produto

		// Product product = createProduct(productService, 1, "Cortina", 100.0);
		// System.out.println("Product created: " + product.getName());

		Product product = productService.findByProductId(1);
		System.out.println("Produto: " + product.getName() + " " + product.getProductId() + " " + product.getPrice());

		// Criando relação
		System.out.println("Criando relação");
		addViewedProduct(personService, person, product);

		// Buscando no BD e verificando resultado

		person = personService.findByPersonId(1);
		Set<Product> updatedViewedProducts = person.getViewedProducts();
		System.out.println("Quant. Produtos: " + updatedViewedProducts.size());
		System.out.println("Produtos: ");
		for (Product p : updatedViewedProducts) {
			System.out.println("Produto: " + product.getName() + " " + product.getProductId() + " " + product.getPrice());
		}
	}

	private static Person createPerson(PersonService service, long id,
			String name, String email) {
		Person person = new Person();
		person.setPersonId(id);
		person.setName(name);
		person.setEmail(email);
		return service.create(person);
	}

	private static Product createProduct(ProductService service, long id,
			String name, Double price) {
		Product product = new Product();
		product.setProductId(id);
		product.setName(name);
		product.setPrice(price);
		return service.create(product);
	}

	private static void addViewedProduct(PersonService personService, Person person, Product product){
		personService.addViewedProduct(person, product);
	}
}

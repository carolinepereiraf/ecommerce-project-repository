package br.com.ecommerce.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;

import br.com.ecommerce.domain.Product;
import br.com.ecommerce.util.ProductUtil;

@Path("/products")
public class ProductsResource {

	/**
	 * Log
	 */
	static Logger log = Logger.getLogger(ProductsResource.class);

	private static ProductUtil productUtil = new ProductUtil();

	/**
	 * Lista todos os produtos existentes com um limite
	 * 
	 * @param limit
	 * @return
	 */
	@GET
	@Produces("application/json")
	public List<Product> getProducts(@QueryParam("limit") int limit) {

		if (limit == 0) {
			log.info("Returning all products");
			return productUtil.listAll();
		}
		log.info("Returning products, limit = " + limit);
		return productUtil.listAllLimitBy(limit);
	}

	/**
	 * Busca um produto com ID especifico
	 * 
	 * @param id
	 * @return
	 */
	@Path("{productId}")
	@GET
	@Produces("application/json")
	public Product getProduct(@PathParam("productId") int id) {
		Product product = productUtil.getOneProductById(id);
		if (product != null) {
			log.info("Returning product " + product.getName());
		} else {
			log.info("No product found for ID " + id);
		}
		return product;
	}

	/**
	 * Adiciona um produto com os parametros especificados
	 * 
	 * @param productId
	 * @param price
	 * @param name
	 * @return
	 */
	@POST
	@Consumes("text/xml")
	@Produces("application/json")
	public String addProduct(@FormParam("productId") int productId,
			@FormParam("price") Double price, @FormParam("name") String name) {
		
		Product product = productUtil.createProduct(productId, name, price);
		String message = null;
		if (product == null) {
			log.info("A product with this productId already exists.");
			message = "Já existe um produto para este ID.";
		} else {
			log.info("Product " + product.getName() + " successfully added.");
			message = product.getName() + " adicionado com sucesso.";
		}
		return message;
	}

	/**
	 * Remove um produto de ID especifico
	 * 
	 * @param id
	 * @return
	 */
	@Path("{productId}")
	@DELETE
	@Produces("application/json")
	public String removeProduct(@PathParam("productId") int id) {
		boolean deleted = productUtil.deleteProduct(id);
		if (deleted) {
			log.info("Product successfully removed.");
		} else {
			log.info("Product could not be removed");
		}

		String message = "Produto removido com sucesso.";
		return message;
	}

}

package br.com.ecommerce.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Person {

	@GraphId
	private Long id;

	private long personId;

	private String email;

	private String name;

	@RelatedTo(type = "VIEWED")
	private Set<Product> viewedProducts;

	@RelatedTo(type = "ADDED_TO_CART")
	private Set<Product> cartProducts;

	@RelatedTo(type = "BOUGHT")
	private Set<Product> boughtProducts;

	public Long getId() {
		return id;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getViewedProducts() {
		return viewedProducts;
	}

	public void addViewedProduct(Product viewedProduct) {
		if (viewedProducts == null) {
			viewedProducts = new HashSet<Product>();
		}
		viewedProducts.add(viewedProduct);
	}

	public void removeViewedProduct(Product viewedProduct) {
		if (viewedProducts != null && !viewedProducts.isEmpty()) {
			viewedProducts.remove(viewedProduct);
		}
	}

	public Set<Product> getCartProducts() {
		return cartProducts;
	}

	public void addCartProduct(Product cartProduct) {
		if (cartProducts == null) {
			cartProducts = new HashSet<Product>();
		}
		cartProducts.add(cartProduct);
	}

	public void removeCartProduct(Product cartProduct) {
		if (cartProducts != null && !cartProducts.isEmpty()) {
			cartProducts.remove(cartProduct);
		}
	}

	public Set<Product> getBoughtProducts() {
		return boughtProducts;
	}
	
	public void addBoughtProduct(Product boughtProduct) {
		if (boughtProducts == null) {
			boughtProducts = new HashSet<Product>();
		}
		boughtProducts.add(boughtProduct);
	}

	public void removeBoughtProduct(Product boughtProduct) {
		if (boughtProducts != null && !boughtProducts.isEmpty()) {
			boughtProducts.remove(boughtProduct);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (personId ^ (personId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (personId != other.personId)
			return false;
		return true;
	}

}

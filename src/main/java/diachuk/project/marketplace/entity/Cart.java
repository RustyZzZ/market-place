package diachuk.project.marketplace.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Cart {
	@Id
	private Long id;
	@ManyToMany
	@JoinTable(name="carts-products",
			joinColumns = @JoinColumn(name = "cart_id"),
			inverseJoinColumns = @JoinColumn(name="product_id"))
	private Set<Product> products;


}

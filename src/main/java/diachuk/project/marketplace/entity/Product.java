package diachuk.project.marketplace.entity;


import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "products")
public class Product {
	@Id
	private Long id;

	private String name;

	private BigDecimal price;
	private Currency currency;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Cart> carts;

}

package diachuk.project.marketplace.entity;


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "products")
public class Product {
	@Id
	private Long id;

	private String name;

	private BigDecimal price;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
}

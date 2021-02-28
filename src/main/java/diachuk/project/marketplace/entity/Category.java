package diachuk.project.marketplace.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	@Id
	private Long id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "category")
	private Set<Product> products;

}

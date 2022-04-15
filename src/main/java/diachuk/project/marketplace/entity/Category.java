package diachuk.project.marketplace.entity;

import java.util.Objects;
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


	@Override
	public boolean equals(Object o) {
		if (this == o) {return true;}
		if (o == null || getClass() != o.getClass()) {return false;}
		Category category = (Category) o;
		return Objects.equals(id, category.id) && Objects.equals(name, category.name) && Objects.equals(description, category.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description);
	}
}

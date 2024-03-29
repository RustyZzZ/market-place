package diachuk.project.marketplace.repos;
import diachuk.project.marketplace.entity.Product;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import diachuk.project.marketplace.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Transactional
	Optional<Category> findCategoryByDescription(String description);

	@Query(value = "SELECT c.id, c.description, c.name, c.products FROM Category as c where c.id = :id ", nativeQuery = true)
	Optional<Category> findMyCategory(Long id);
}

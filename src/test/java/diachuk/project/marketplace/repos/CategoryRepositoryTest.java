package diachuk.project.marketplace.repos;

import diachuk.project.marketplace.entity.Category;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CategoryRepositoryTest {
	public static final String DESCRIPTION = "Desc";
	@Autowired
	private  CategoryRepository categoryRepository;

	@Autowired
	private TestEntityManager entityManager;



	@Test
	void testFindCategoryByDescription() {

		var expectedCategory = Category.builder()
								   .name("MyBestCategory")
								   .id(1L)
								   .description(DESCRIPTION)
								   .build();
		entityManager.persist(expectedCategory);
		entityManager.flush();
		var actualCategory = categoryRepository.findCategoryByDescription(DESCRIPTION);

		Assertions.assertThat(actualCategory.get()).isEqualTo(expectedCategory);
	}

	@Test
	void testFindCategoryByDescriptionNotSuccess() {
		var expectedCategory = Category.builder()
									   .name("MyBestCategory")
									   .id(1L)
									   .description(DESCRIPTION)
									   .build();
		entityManager.persist(expectedCategory);
		entityManager.flush();

		var actualCategory = categoryRepository
				.findCategoryByDescription(DESCRIPTION+"s");

		Assertions.assertThat(actualCategory.isPresent()).isEqualTo(false);

	}
}
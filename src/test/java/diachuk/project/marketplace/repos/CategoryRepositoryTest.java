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
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
class CategoryRepositoryTest {
	public static final String DESCRIPTION = "Desc";
	@Autowired
	private CategoryRepository categoryRepository;
	@Container
	public static PostgreSQLContainer<?> postgreDBContainer = new PostgreSQLContainer<>("postgres:9.4")
			.withDatabaseName("marketplace")
			.withUsername("postgres")
			.withPassword("postgres")
			.withExposedPorts(5432);



	@Test
	void testFindCategoryByDescription() {

		var expectedCategory = Category.builder()
									   .name("MyBestCategory")
									   .id(1L)
									   .description(DESCRIPTION)
									   .build();
		categoryRepository.save(expectedCategory);
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
		categoryRepository.save(expectedCategory);

		var actualCategory = categoryRepository
				.findCategoryByDescription(DESCRIPTION+"s");

		Assertions.assertThat(actualCategory.isPresent()).isEqualTo(false);

	}
}
package diachuk.project.marketplace.services;

import diachuk.project.marketplace.entity.Category;
import diachuk.project.marketplace.mapper.CategoryMapper;
import diachuk.project.marketplace.repos.CategoryRepository;
import diachuk.project.marketplace.stubs.CategoryStub;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static diachuk.project.marketplace.stubs.CategoryStub.ID;
import static diachuk.project.marketplace.stubs.CategoryStub.getCategoryRequest;
import static diachuk.project.marketplace.stubs.CategoryStub.getRandomCategory;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class CategoryServiceTest {
	private CategoryService service;

	@Mock
	private CategoryRepository categoryRepository;
	@Mock
	private CategoryMapper categoryMapper;
	@Captor
	private ArgumentCaptor<Long> captor;

	@BeforeEach
	void setup() {
		service = new CategoryService(categoryRepository, categoryMapper);
	}

	@Test
	void testSuccessfulGetById() {
		var category = CategoryStub.getRandomCategory();
		when(categoryRepository.findById(any())).thenReturn(Optional.of(category));
		var result = service.getById(ID);
		assertAll(
				() -> assertEquals(result.getId(), category.getId()),
				() -> assertEquals(result.getName(), category.getName()),
				() -> assertEquals(result.getDescription(), category.getDescription()),
				() -> assertEquals(result.getProducts().size(), category.getProducts().size()));

	}
	@Test
	void testNotSuccessfulGetById(){
		when(categoryRepository.findById(any())).thenReturn(Optional.empty());
		var e =
				assertThrows(NoSuchElementException.class, () -> service.getById(ID));
		assertEquals(e.getMessage(),"No value present");
	}


	@Test
	void testSuccessfulSave() {
		//given
		var captor = ArgumentCaptor.forClass(Category.class);
		var category = getRandomCategory();
		when(categoryMapper.fromRequest(any())).thenReturn(category);
		when(categoryRepository.save(any())).thenReturn(getRandomCategory());
		//when
		var result = service.create(getCategoryRequest());
		//then
		Mockito.verify(categoryRepository, atLeast(1)).save(captor.capture());
		assertEquals(category, captor.getValue());
		assertEquals(category.getName(), result.getName());
	}
	@Test
	void testSuccessfulDelete(){
		service.delete(ID);
		var captor = ArgumentCaptor.forClass(Long.class);
		Mockito.verify(categoryRepository, atLeast(1)).deleteById(captor.capture());
		assertEquals(ID,captor.getValue());
	}
}
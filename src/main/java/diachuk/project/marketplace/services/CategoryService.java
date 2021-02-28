package diachuk.project.marketplace.services;

import diachuk.project.marketplace.dto.CategoryRequest;
import diachuk.project.marketplace.entity.Category;
import diachuk.project.marketplace.repos.CategoryRepository;
import java.util.HashSet;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
	private final CategoryRepository repo;

	public Category getById(Long id) {
		return repo.findById(id).orElseThrow();

	}

	public Category create(CategoryRequest request) {
		var category = Category.builder()
							.id(new Random().nextLong())
							.description(request.getDescription())
							.name(request.getName())
							.products(new HashSet<>()).build();
		return repo.save(category);
	}

}

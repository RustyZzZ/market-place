package diachuk.project.marketplace.services;

import diachuk.project.marketplace.dto.CategoryRequest;
import diachuk.project.marketplace.entity.Category;
import diachuk.project.marketplace.mapper.CategoryMapper;
import diachuk.project.marketplace.repos.CategoryRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
	private final CategoryRepository repo;
	private final CategoryMapper mapper;

	public Category getById(Long id) {
		return repo.findById(id).orElseThrow();

	}

	public Category create(CategoryRequest request) {
		var category =  mapper.fromRequest(request);

		category.setName("AGVAVAV "+category.getName());
		return repo.save(category);
	}


	public void delete(Long id){
		//repo.deleteById(id);
	}

	public List<Category> getAll(){
		return repo.findAll();
	}
}

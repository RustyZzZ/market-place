package diachuk.project.marketplace.mapper;

import diachuk.project.marketplace.dto.CategoryRequest;
import diachuk.project.marketplace.entity.Category;
import java.util.HashSet;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

	public Category fromRequest(CategoryRequest request){
		return Category.builder()
					   .id(new Random().nextLong())
					   .description(request.getDescription())
					   .name(request.getName())
					   .products(new HashSet<>()).build();
	}
}

package diachuk.project.marketplace.stubs;

import diachuk.project.marketplace.dto.CategoryRequest;
import diachuk.project.marketplace.entity.Category;
import java.util.HashSet;

public final class CategoryStub {
	public static final Long ID = 1L;
	public static final String NAME = "NAME";
	public static final String DESCRIPTION = "DESCRIPTION";
	public static Category getRandomCategory(){
		return Category.builder()
					   .id(ID)
					   .name(NAME)
					   .description(DESCRIPTION)
					   .products(new HashSet<>())
					   .build();
	}

	public static CategoryRequest getCategoryRequest(){
		var categoryRequest = new CategoryRequest();
		categoryRequest.setName(NAME);
		categoryRequest.setDescription(DESCRIPTION);
		return categoryRequest;
	}

}

package diachuk.project.marketplace.controller;

import diachuk.project.marketplace.dto.CategoryRequest;
import diachuk.project.marketplace.entity.Category;
import diachuk.project.marketplace.entity.Product;
import diachuk.project.marketplace.services.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/categories")
@Api(value = "Category controller")
public class V1CategoryController {
	private final CategoryService service;


	@GetMapping()
	public List<Category> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
			@RequestParam(required = false, defaultValue = "1") Integer page
	) {
		return null;
	}

	@ApiOperation( value = "Get by id", notes = "This method get by id")
	@GetMapping("/{id}")
	@ApiResponse(code=200, message = "Successful get by id")
	public Category get(@PathVariable Long id) {
		return service.getById(id);
	}

	@PostMapping
	public Category create(@RequestBody CategoryRequest category) {
		return service.create(category);
	}

	@PutMapping("/{id}")
	public Category update(@PathVariable Long id, @RequestBody Category category) {
		return null;
	}

	@DeleteMapping("/{id}")
	public void delete(Long id) {}

	@GetMapping("/{categoryId}/products")
	public List<Product> getProductByCategory(@PathVariable Long categoryId) {
		return null;
	}


}

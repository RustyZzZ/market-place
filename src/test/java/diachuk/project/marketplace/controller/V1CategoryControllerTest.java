package diachuk.project.marketplace.controller;

import diachuk.project.marketplace.entity.Category;
import diachuk.project.marketplace.repos.CategoryRepository;
import diachuk.project.marketplace.services.CategoryService;
import java.util.ArrayList;
import org.assertj.core.util.Arrays;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class V1CategoryControllerTest {
	@MockBean
	CategoryRepository categoryRepository;

	@Autowired
	private MockMvc mvc;


	@Test

	void name() throws Exception {
		var category = Category.builder().name("name").description("desc").id(1L).build();
		var list = new ArrayList<Category>();
		var add = list.add(category);
		when(categoryRepository.findAll()).thenReturn(list);

		mvc.perform(get("/v1/categories")
				.accept(MediaType.APPLICATION_JSON)
		)
		   .andExpect(status().isOk())
		   .andDo(print())
		   .andExpect(jsonPath("$").isArray())
		   .andExpect(content().string(containsString(category.getDescription())));
	}

}
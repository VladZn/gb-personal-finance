package ru.gb.dev.spring.pfs.statistics.dto;

import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import ru.gb.dev.spring.pfs.statistics.model.dto.CategoryDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Category;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;
import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

public class CategoryDtoTest {

	private ModelMapper mapper;

	@Before
	public void init() {
		mapper = new ModelMapper();
		mapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STRICT)
				.setFieldMatchingEnabled(true)
				.setSkipNullEnabled(true)
				.setFieldAccessLevel(PRIVATE);
	}

	@Test
	public void whenConvertCategoryEntityToCategoryDto_thenCorrect() {
		// given
		final Category category = new Category();
		category.setName(randomAlphabetic(8));
		category.setActive(true);

		// when
		final CategoryDto categoryDto = mapper.map(category, CategoryDto.class);

		// then
		assertEquals(category.getId(), categoryDto.getId());
		assertEquals(category.getName(), categoryDto.getName());
		assertEquals(category.getActive(), Boolean.valueOf(categoryDto.getActive()));
	}

	@Test
	public void whenConvertCategoryDtoToCategoryEntity_thenCorrect() {
		// given
		final CategoryDto categoryDto = new CategoryDto();
		categoryDto.setName(randomAlphabetic(8));
		categoryDto.setActive(Boolean.TRUE.toString());

		// when
		final Category category = mapper.map(categoryDto, Category.class);

		// then
		assertEquals(categoryDto.getId(), category.getId());
		assertEquals(categoryDto.getName(), category.getName());
		assertEquals(categoryDto.getActive(), String.valueOf(category.getActive()));
	}

}

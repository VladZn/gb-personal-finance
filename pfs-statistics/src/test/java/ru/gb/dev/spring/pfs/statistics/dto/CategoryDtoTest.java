package ru.gb.dev.spring.pfs.statistics.dto;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import ru.gb.dev.spring.pfs.statistics.model.dto.CategoryDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Category;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;

public class CategoryDtoTest {

	private static final String TRUE = "true";

	private final ModelMapper modelMapper = new ModelMapper();

	@Test
	public void whenConvertCategoryToCategoryDto_thenCorrect() {
		final Category category = new Category();
		category.setName(randomAlphabetic(8));
		category.setActive(true);

		final CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
		assertEquals(category.getId(), categoryDto.getId());
		assertEquals(category.getName(), categoryDto.getName());
//        assertEquals(category.getActive(), Boolean.valueOf(categoryDto.getActive()));
	}

	@Test
	public void whenConvertPostDtoToPostEntity_thenCorrect() {
		final CategoryDto categoryDto = new CategoryDto();
		categoryDto.setName(randomAlphabetic(8));
		categoryDto.setActive(TRUE);

		final Category category = modelMapper.map(categoryDto, Category.class);
		assertEquals(categoryDto.getId(), category.getId());
		assertEquals(categoryDto.getName(), category.getName());
		assertEquals(categoryDto.getActive(), String.valueOf(category.getActive()));
	}

}

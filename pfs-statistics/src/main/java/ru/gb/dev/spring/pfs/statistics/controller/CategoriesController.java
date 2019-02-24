package ru.gb.dev.spring.pfs.statistics.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.dev.spring.pfs.statistics.exception.EntityNotFoundException;
import ru.gb.dev.spring.pfs.statistics.model.dto.CategoryDto;
import ru.gb.dev.spring.pfs.statistics.controller.dto.ResultDto;
import ru.gb.dev.spring.pfs.statistics.controller.dto.SuccessDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Category;
import ru.gb.dev.spring.pfs.statistics.model.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

	private final CategoryService service;

	private final ModelMapper modelMapper;

	@Autowired
	public CategoriesController(final CategoryService service, final ModelMapper modelMapper) {
		this.service = service;
		this.modelMapper = modelMapper;
	}

	@GetMapping(value = "/ping", produces = APPLICATION_JSON_UTF8_VALUE)
	public ResultDto ping() {
		return new SuccessDto();
	}

	@GetMapping(value = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
	public CategoryDto get(@PathVariable("id") final String id) {
		return service.findById(id)
				.map(category -> modelMapper.map(category, CategoryDto.class))
				.orElseThrow(() -> new EntityNotFoundException("Logo with id " + id + "not found"));
	}

	@GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
	public List<CategoryDto> getAll() {
		final Iterable<Category> categories = service.findAll();
		return StreamSupport
				.stream(categories.spliterator(), false)
				.map(category -> modelMapper.map(category, CategoryDto.class))
				.collect(Collectors.toList());
	}

	@PostMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	public ResultDto post(final CategoryDto categoryDto) {
		service.save(categoryDto);
		return new ResultDto();
	}

	@PutMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	public ResultDto put(final CategoryDto categoryDto) {
		service.save(categoryDto);
		return new ResultDto();
	}

	@DeleteMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	public ResultDto delete(final String categoryId) {
		service.deleteById(categoryId);
		return new ResultDto();
	}

	@DeleteMapping(produces = APPLICATION_JSON_UTF8_VALUE)
	public ResultDto deleteAll() {
		service.deleteAll();
		return new ResultDto();
	}

}

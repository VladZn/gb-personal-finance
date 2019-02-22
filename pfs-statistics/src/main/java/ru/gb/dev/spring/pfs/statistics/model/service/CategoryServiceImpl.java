package ru.gb.dev.spring.pfs.statistics.model.service;

import org.jetbrains.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ru.gb.dev.spring.pfs.statistics.exception.EntityNotFoundException;
import ru.gb.dev.spring.pfs.statistics.model.dto.CategoryDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Category;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;
import ru.gb.dev.spring.pfs.statistics.model.repository.CategoryRepository;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository repository;

	private final ModelMapper modelMapper;

	@Autowired
	public CategoryServiceImpl(final CategoryRepository repository, final ModelMapper modelMapper) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}

	@Override
	public @Nullable <S extends Category> S save(final @Nullable S category) {
		if (category == null || StringUtils.isEmpty(category.getId())) {
			throw new EntityNotFoundException("category is not valid");
		}
		return repository.save(category);
	}

	@Override
	public <S extends Category> Iterable<S> saveAll(final Iterable<S> ads) {
		return repository.saveAll(ads);
	}

	@Override
	public Optional<Category> findById(final String id) {
		return repository.findById(id);
	}

	@Override
	public boolean existsById(final String id) {
		return repository.existsById(id);
	}

	@Override
	public Iterable<Category> findAll() {
		return repository.findAll();
	}

	@Override
	public Iterable<Category> findAllById(final Iterable<String> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public Iterable<Category> findAllByLogo(final Logo logo) {
		return repository.findAllByLogo(logo);
	}

	@Override
	public long count() {
		return repository.count();
	}

	@Override
	public void deleteById(final String id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(final @Nullable Category category) throws EntityNotFoundException {
		if (category == null || StringUtils.isEmpty(category.getId())) {
			throw new EntityNotFoundException("category is not valid");
		}
		repository.delete(category);
	}

	@Override
	public void deleteAll(final Iterable<? extends Category> ads) {
		repository.deleteAll(ads);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public void save(final CategoryDto categoryDto) {
		if (categoryDto == null) {
			return;
		}
		final Category category = modelMapper.map(categoryDto, Category.class);
		category.setId(categoryDto.getId());
		save(category);
	}

	@Override
	public void delete(final CategoryDto categoryDto) {
		if (categoryDto == null) {
			return;
		}
		deleteById(categoryDto.getId());
	}

}

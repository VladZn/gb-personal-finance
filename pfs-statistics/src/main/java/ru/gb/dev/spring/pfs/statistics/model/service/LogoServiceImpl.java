package ru.gb.dev.spring.pfs.statistics.model.service;

import org.jetbrains.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ru.gb.dev.spring.pfs.statistics.exception.EntityNotFoundException;
import ru.gb.dev.spring.pfs.statistics.model.dto.LogoDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;
import ru.gb.dev.spring.pfs.statistics.model.repository.LogoRepository;

import java.util.Optional;

@Service
public class LogoServiceImpl implements LogoService {

	private final LogoRepository repository;

	private final ModelMapper modelMapper;

	@Autowired
	public LogoServiceImpl(final LogoRepository repository, final ModelMapper modelMapper) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public @Nullable <S extends Logo> S save(final @Nullable S logo) {
		if (logo == null || StringUtils.isEmpty(logo.getId())) {
			throw new EntityNotFoundException("logo is not valid");
		}
		return repository.save(logo);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public <S extends Logo> Iterable<S> saveAll(final Iterable<S> ads) {
		return repository.saveAll(ads);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Optional<Logo> findById(final String id) {
		return repository.findById(id);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public boolean existsById(final String id) {
		return repository.existsById(id);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Iterable<Logo> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Iterable<Logo> findAllById(final Iterable<String> ids) {
		return repository.findAllById(ids);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public long count() {
		return repository.count();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(final String id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(final @Nullable Logo logo) throws EntityNotFoundException {
		if (logo == null || StringUtils.isEmpty(logo.getId())) {
			throw new EntityNotFoundException("logo is not valid");
		}
		repository.delete(logo);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteAll(final Iterable<? extends Logo> ads) {
		repository.deleteAll(ads);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void save(final LogoDto logoDto) {
		if (logoDto == null) {
			return;
		}
		Logo logo = modelMapper.map(logoDto, Logo.class);
		logo.setId(logoDto.getId());
		save(logo);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(final LogoDto logoDto) {
		if (logoDto == null) {
			return;
		}
		deleteById(logoDto.getId());
	}

}

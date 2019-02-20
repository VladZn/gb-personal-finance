package ru.gb.dev.spring.pfs.statistics.model.service;

import org.jetbrains.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ru.gb.dev.spring.pfs.statistics.exception.EntityNotFoundException;
import ru.gb.dev.spring.pfs.statistics.model.dto.OperationDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Category;
import ru.gb.dev.spring.pfs.statistics.model.entity.Client;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;
import ru.gb.dev.spring.pfs.statistics.model.entity.Operation;
import ru.gb.dev.spring.pfs.statistics.model.repository.OperationRepository;

import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {

    private final OperationRepository repository;

    private final ModelMapper modelMapper;

    @Autowired
    public OperationServiceImpl(final OperationRepository repository, final ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public @Nullable <S extends Operation> S save(final @Nullable S operation) {
        if (operation == null || StringUtils.isEmpty(operation.getId())) {
            throw new EntityNotFoundException("operation is not valid");
        }
        return repository.save(operation);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public <S extends Operation> Iterable<S> saveAll(final Iterable<S> ads) {
        return repository.saveAll(ads);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Optional<Operation> findById(final String id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public boolean existsById(final String id) {
        return repository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Iterable<Operation> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Iterable<Operation> findAllById(final Iterable<String> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public Iterable<Operation> findAllByClient(final Client client) {
        return repository.findAllByClient(client);
    }

    @Override
    public Iterable<Operation> findAllByCategory(final Category category) {
        return repository.findAllByCategory(category);
    }

    @Override
    public Iterable<Operation> findAllByLogo(final Logo logo) {
        return repository.findAllByLogo(logo);
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
    public void delete(final @Nullable Operation operation) throws EntityNotFoundException {
        if (operation == null || StringUtils.isEmpty(operation.getId())) {
            throw new EntityNotFoundException("operation is not valid");
        }
        repository.delete(operation);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteAll(final Iterable<? extends Operation> ads) {
        repository.deleteAll(ads);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void save(final OperationDto operationDto) {
        if (operationDto == null) {
            return;
        }
        final Operation operation = modelMapper.map(operationDto, Operation.class);
        operation.setId(operationDto.getId());
        save(operation);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(final OperationDto operationDto) {
        if (operationDto == null) {
            return;
        }
        deleteById(operationDto.getId());
    }

}

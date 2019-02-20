package ru.gb.dev.spring.pfs.statistics.model.service;

import org.jetbrains.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ru.gb.dev.spring.pfs.statistics.exception.EntityNotFoundException;
import ru.gb.dev.spring.pfs.statistics.model.dto.ClientDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Client;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;
import ru.gb.dev.spring.pfs.statistics.model.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    private final ModelMapper modelMapper;

    @Autowired
    public ClientServiceImpl(final ClientRepository repository, final ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public @Nullable <S extends Client> S save(final @Nullable S client) {
        if (client == null || StringUtils.isEmpty(client.getId())) {
            throw new EntityNotFoundException("client is not valid");
        }
        return repository.save(client);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public <S extends Client> Iterable<S> saveAll(final Iterable<S> ads) {
        return repository.saveAll(ads);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Optional<Client> findById(final String id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public boolean existsById(final String id) {
        return repository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Iterable<Client> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Iterable<Client> findAllById(final Iterable<String> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public Iterable<Client> findAllByLogo(final Logo logo) {
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
    public void delete(final @Nullable Client client) throws EntityNotFoundException {
        if (client == null || StringUtils.isEmpty(client.getId())) {
            throw new EntityNotFoundException("client is not valid");
        }
        repository.delete(client);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteAll(final Iterable<? extends Client> ads) {
        repository.deleteAll(ads);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void save(final ClientDto clientDto) {
        if (clientDto == null) {
            return;
        }
        final Client client = modelMapper.map(clientDto, Client.class);
        client.setId(clientDto.getId());
        save(client);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(final ClientDto clientDto) {
        if (clientDto == null) {
            return;
        }
        deleteById(clientDto.getId());
    }

}

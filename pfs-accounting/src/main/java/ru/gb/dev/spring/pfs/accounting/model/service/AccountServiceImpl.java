package ru.gb.dev.spring.pfs.accounting.model.service;

import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ru.gb.dev.spring.pfs.accounting.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;
import ru.gb.dev.spring.pfs.accounting.model.repository.AccountRepository;
import ru.gb.dev.spring.pfs.accounting.util.NotFoundException;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Autowired
    public AccountServiceImpl(final AccountRepository repository) {
        this.repository = repository;
    }

    @Nullable
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public <S extends Account> S save(@Nullable final S account) {
        if (account == null || StringUtils.isEmpty(account.getId()))
            throw new NotFoundException("account is not valid");
        return repository.save(account);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public <S extends Account> Iterable<S> saveAll(final Iterable<S> ads) {
        return repository.saveAll(ads);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Optional<Account> findById(@Nullable final String id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public boolean existsById(@Nullable final String id) {
        return repository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Iterable<Account> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Iterable<Account> findAllById(final Iterable<String> ids) {
        return repository.findAllById(ids);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public long count() {
        return repository.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(@Nullable final String id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(@Nullable final Account account) throws NotFoundException {
        if (account == null || StringUtils.isEmpty(account.getId()))
            throw new NotFoundException("account is not valid");
        repository.delete(account);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteAll(final Iterable<? extends Account> ads) {
        repository.deleteAll(ads);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void save(final AccountDto accountDto) {
        if (accountDto == null) return;
        final Optional<Account> optional = findById(accountDto.getId());
        final Account account = optional.orElseGet(Account::new);
        account.setId(accountDto.getId());
        account.setName(accountDto.getName());
        account.setAmount(new BigDecimal(accountDto.getAmount()));
        account.setUserId(accountDto.getUserId());
        account.setTypeId(accountDto.getTypeId());
        account.setIconId(accountDto.getIconId());
        save(account);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(final AccountDto accountDto) {
        if (accountDto == null) return;
        deleteById(accountDto.getId());
    }

}

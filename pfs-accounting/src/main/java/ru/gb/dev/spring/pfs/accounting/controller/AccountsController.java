package ru.gb.dev.spring.pfs.accounting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.dev.spring.pfs.accounting.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.accounting.controller.dto.ResultDto;
import ru.gb.dev.spring.pfs.accounting.controller.dto.SuccessDto;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;
import ru.gb.dev.spring.pfs.accounting.model.mapper.AccountMapper;
import ru.gb.dev.spring.pfs.accounting.model.service.AccountService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/api/accounts", produces = APPLICATION_JSON_UTF8_VALUE)
public class AccountsController {

    private final AccountService service;
    private final AccountMapper mapper;

    @Autowired
    public AccountsController(final AccountService service, AccountMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/ping")
    public ResultDto ping() {
        return new SuccessDto();
    }

    @GetMapping(value = "{id}")
    public AccountDto findOne(@PathVariable("id") final String id) {
        return service.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Account with id " + id + "not found"));
    }

    @GetMapping
    public List<AccountDto> findAll() {
        final Iterable<Account> accounts = service.findAll();
        return StreamSupport
                .stream(accounts.spliterator(), false)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultDto create(final AccountDto accountDto) {
        service.save(accountDto);
        return new ResultDto();
    }

    @PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultDto update(final AccountDto accountDto) {
        service.save(accountDto);
        return new ResultDto();
    }

    @DeleteMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResultDto delete(final String accountId) {
        service.deleteById(accountId);
        return new ResultDto();
    }

    @DeleteMapping
    public ResultDto deleteAll() {
        service.deleteAll();
        return new ResultDto();
    }

}

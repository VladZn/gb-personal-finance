package ru.gb.dev.spring.pfs.accounting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.dev.spring.pfs.accounting.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.accounting.model.dto.util.ResultDto;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;
import ru.gb.dev.spring.pfs.accounting.model.service.AccountService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/accounts")
public class AccountsResource {

    private final AccountService service;

    @Autowired
    public AccountsResource(final AccountService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    public List<AccountDto> get() {
        final Iterable<Account> accounts = service.findAll();
        return StreamSupport
                .stream(accounts.spliterator(), false)
                .map(AccountDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResultDto post(final AccountDto[] accounts) {
        for (final AccountDto account : accounts) {
            service.save(account);
        }
        return new ResultDto();
    }


    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResultDto put(final AccountDto[] accounts) {
        for (final AccountDto account : accounts) {
            service.save(account);
        }
        return new ResultDto();
    }

    @DeleteMapping(consumes = "application/json", produces = "application/json")
    public ResultDto delete(final AccountDto[] accounts) {
        for (final AccountDto account : accounts) {
            service.delete(account);
        }
        return new ResultDto();
    }

}

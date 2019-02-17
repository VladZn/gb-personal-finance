package ru.gb.dev.spring.pfs.accounting.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.dev.spring.pfs.accounting.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.accounting.model.dto.util.ResultDto;
import ru.gb.dev.spring.pfs.accounting.model.dto.util.SuccessDto;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;
import ru.gb.dev.spring.pfs.accounting.model.service.AccountService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/accounts")
public class AccountsResource extends AbstractBaseResource {

    private final ModelMapper modelMapper;

    private final AccountService service;

    @Autowired
    public AccountsResource(final ModelMapper modelMapper, final AccountService service) {
        this.modelMapper = modelMapper;
        this.service = service;
    }

    @GetMapping(value = "/ping")
    public ResultDto ping() {
        return new SuccessDto();
    }

    @GetMapping
    public List<AccountDto> get() {
        final Iterable<Account> accounts = service.findAll();
        return StreamSupport
                .stream(accounts.spliterator(), false)
                .map(account -> modelMapper.map(account, AccountDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResultDto post(final AccountDto[] accounts) {
        for (final AccountDto account : accounts) {
            service.save(account);
        }
        return new ResultDto();
    }


    @PutMapping
    public ResultDto put(final AccountDto[] accounts) {
        for (final AccountDto account : accounts) {
            service.save(account);
        }
        return new ResultDto();
    }

    @DeleteMapping
    public ResultDto delete(final AccountDto[] accounts) {
        for (final AccountDto account : accounts) {
            service.delete(account);
        }
        return new ResultDto();
    }

}

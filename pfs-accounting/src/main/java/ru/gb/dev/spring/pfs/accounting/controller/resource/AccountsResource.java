package ru.gb.dev.spring.pfs.accounting.controller.resource;

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

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/api/accounts")
public class AccountsResource {

    private final ModelMapper modelMapper;

    private final AccountService service;

    @Autowired
    public AccountsResource(final ModelMapper modelMapper, final AccountService service) {
        this.modelMapper = modelMapper;
        this.service = service;
    }

    @GetMapping(value = "/ping", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultDto ping() {
        return new SuccessDto();
    }

    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public List<AccountDto> get() {
        final Iterable<Account> accounts = service.findAll();
        return StreamSupport
                .stream(accounts.spliterator(), false)
                .map(account -> modelMapper.map(account, AccountDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping(
            consumes = APPLICATION_JSON_UTF8_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE
    )
    public ResultDto post(final AccountDto[] accounts) {
        for (final AccountDto account : accounts) {
            service.save(account);
        }
        return new ResultDto();
    }


    @PutMapping(
            consumes = APPLICATION_JSON_UTF8_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE
    )
    public ResultDto put(final AccountDto[] accounts) {
        for (final AccountDto account : accounts) {
            service.save(account);
        }
        return new ResultDto();
    }

    @DeleteMapping(
            consumes = APPLICATION_JSON_UTF8_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE
    )
    public ResultDto delete(final AccountDto[] accounts) {
        for (final AccountDto account : accounts) {
            service.delete(account);
        }
        return new ResultDto();
    }

}

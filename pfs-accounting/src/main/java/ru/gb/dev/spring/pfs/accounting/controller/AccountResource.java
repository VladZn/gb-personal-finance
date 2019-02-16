package ru.gb.dev.spring.pfs.accounting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import ru.gb.dev.spring.pfs.accounting.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.accounting.model.dto.util.ResultDto;
import ru.gb.dev.spring.pfs.accounting.model.dto.util.SuccessDto;
import ru.gb.dev.spring.pfs.accounting.model.service.AccountService;

@RestController
@RequestMapping("api/account")
public class AccountResource {

    private final AccountService service;

    @Autowired
    public AccountResource(final AccountService service) {
        this.service = service;
    }

    @RequestMapping(value = "/ping", produces = "application/json")
    public ResultDto ping() {
        return new SuccessDto();
    }

    @GetMapping(value = "{id}", produces = "application/json")
    public AccountDto get(@PathVariable("id") final String id) {
        return service.findById(id).map(AccountDto::new).orElse(null);
    }

    @PostMapping(produces = "application/json")
    public ResultDto post(final AccountDto accountDto) {
        service.save(accountDto);
        return new ResultDto();
    }

    @PutMapping(produces = "application/json")
    public ResultDto put(final AccountDto accountDto) {
        service.save(accountDto);
        return new ResultDto();
    }

    @DeleteMapping(produces = "application/json")
    public ResultDto delete(final AccountDto accountDto) {
        service.delete(accountDto);
        return new ResultDto();
    }

}

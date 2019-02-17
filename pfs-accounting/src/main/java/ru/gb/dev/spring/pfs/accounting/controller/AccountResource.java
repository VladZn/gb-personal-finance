package ru.gb.dev.spring.pfs.accounting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.dev.spring.pfs.accounting.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.accounting.model.dto.util.ResultDto;
import ru.gb.dev.spring.pfs.accounting.model.dto.util.SuccessDto;
import ru.gb.dev.spring.pfs.accounting.model.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountResource extends AbstractBaseResource{

    private final AccountService service;

    @Autowired
    public AccountResource(final AccountService service) {
        this.service = service;
    }

    @GetMapping(value = "/ping")
    public ResultDto ping() {
        return new SuccessDto();
    }

    @GetMapping(value = "{id}")
    public AccountDto get(@PathVariable("id") final String id) {
        return service.findById(id).map(AccountDto::new).orElse(null);
    }

    @PostMapping
    public ResultDto post(final AccountDto accountDto) {
        service.save(accountDto);
        return new ResultDto();
    }

    @PutMapping
    public ResultDto put(final AccountDto accountDto) {
        service.save(accountDto);
        return new ResultDto();
    }

    @DeleteMapping
    public ResultDto delete(final AccountDto accountDto) {
        service.delete(accountDto);
        return new ResultDto();
    }

}

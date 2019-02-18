package ru.gb.dev.spring.pfs.accounting.controller.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.dev.spring.pfs.accounting.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.accounting.model.dto.util.ResultDto;
import ru.gb.dev.spring.pfs.accounting.model.dto.util.SuccessDto;
import ru.gb.dev.spring.pfs.accounting.model.entity.Account;
import ru.gb.dev.spring.pfs.accounting.model.service.AccountService;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/api/account")
public class AccountResource {

    private final AccountService service;

    private final ModelMapper modelMapper;

    @Autowired
    public AccountResource(final AccountService service, final ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/ping", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultDto ping() {
        return new SuccessDto();
    }

    @GetMapping(value = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public AccountDto get(@PathVariable("id") final String id) {
        final Optional<Account> optional = service.findById(id);
        if (!optional.isPresent()) return null;
        return modelMapper.map(optional.get(), AccountDto.class);
    }

    @PostMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultDto post(final AccountDto accountDto) {
        service.save(accountDto);
        return new ResultDto();
    }

    @PutMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultDto put(final AccountDto accountDto) {
        service.save(accountDto);
        return new ResultDto();
    }

    @DeleteMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public ResultDto delete(final AccountDto accountDto) {
        service.delete(accountDto);
        return new ResultDto();
    }

}

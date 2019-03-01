package ru.gd.dev.spring.pfs.ui.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.gd.dev.spring.pfs.ui.controller.dto.ResultDto;
import ru.gd.dev.spring.pfs.ui.dto.AccountDto;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping(value = "/api/accounts", produces = APPLICATION_JSON_UTF8_VALUE)
@FeignClient(name = "accounting")
public interface AccountService {

    @GetMapping("/ping")
    ResultDto ping();

    @GetMapping("{id}")
    AccountDto findOne(@PathVariable("id") final String id);

    @GetMapping
    List<AccountDto> findAll();

    @PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
    ResultDto add(final AccountDto accountDto);

    @PutMapping(value = "{id}", consumes = APPLICATION_JSON_UTF8_VALUE)
    ResultDto update(@PathVariable("id") final String id, final AccountDto accountDto);

    @DeleteMapping(value = "{id}", consumes = APPLICATION_JSON_UTF8_VALUE)
    ResultDto delete(@PathVariable("id") final String accountId);

    @DeleteMapping
    ResultDto deleteAll();

}

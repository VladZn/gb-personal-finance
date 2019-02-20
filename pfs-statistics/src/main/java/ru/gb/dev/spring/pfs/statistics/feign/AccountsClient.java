package ru.gb.dev.spring.pfs.statistics.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.dev.spring.pfs.statistics.model.dto.OperationDto;
import ru.gb.dev.spring.pfs.statistics.model.dto.util.ResultDto;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping("/api/accounts")
@FeignClient(name = "account")
public interface AccountsClient {

    @GetMapping(value = "/ping",  produces = APPLICATION_JSON_UTF8_VALUE)
    ResultDto ping();

    @GetMapping(value = "{id}",  produces = APPLICATION_JSON_UTF8_VALUE)
    OperationDto getAccount(@PathVariable("id") final String accountId);
    
    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    List<OperationDto> getAccounts();

}

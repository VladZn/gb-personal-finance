package ru.gb.dev.spring.pfs.accounting.controller.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.dev.spring.pfs.accounting.model.dto.OperationDto;
import ru.gb.dev.spring.pfs.accounting.model.dto.util.ResultDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping("/api/operation")
@FeignClient(name = "operation")
public interface OperationClient {

    @GetMapping(value = "/ping",  produces = APPLICATION_JSON_UTF8_VALUE)
    ResultDto ping();

    @GetMapping(value = "{id}",  produces = APPLICATION_JSON_UTF8_VALUE)
    OperationDto getOperation(@PathVariable("id") final String operationId);

}

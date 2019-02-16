package ru.gb.dev.spring.pfs.accounting.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.dev.spring.pfs.accounting.model.dto.OperationDto;
import ru.gb.dev.spring.pfs.accounting.model.dto.util.ResultDto;

@RequestMapping("/api")
@FeignClient(name = "operation")
public interface OperationClient {

    @RequestMapping(value = "/ping", produces = "application/json")
    ResultDto ping();

    @RequestMapping(value = "{id}", produces = "application/json", method = RequestMethod.GET)
    OperationDto getOperation(@PathVariable("id") final String operationId);

}

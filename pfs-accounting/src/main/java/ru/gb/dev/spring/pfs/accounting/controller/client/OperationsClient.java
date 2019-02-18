package ru.gb.dev.spring.pfs.accounting.controller.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.dev.spring.pfs.accounting.model.dto.OperationDto;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping("/api/operations")
@FeignClient(name = "operation")
public interface OperationsClient {

    @GetMapping(value = "/operations",  produces = APPLICATION_JSON_UTF8_VALUE)
    List<OperationDto> getOperations();

}

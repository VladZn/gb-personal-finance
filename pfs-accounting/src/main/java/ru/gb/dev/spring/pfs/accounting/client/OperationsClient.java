package ru.gb.dev.spring.pfs.accounting.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.dev.spring.pfs.accounting.model.dto.OperationDto;

import java.util.List;

@RequestMapping("/api")
@FeignClient(name = "operation")
public interface OperationsClient {

    @RequestMapping(value = "/operations", produces = "application/json", method = RequestMethod.GET)
    List<OperationDto> getOperations();

}

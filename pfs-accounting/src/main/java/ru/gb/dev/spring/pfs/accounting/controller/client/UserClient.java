package ru.gb.dev.spring.pfs.accounting.controller.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.dev.spring.pfs.accounting.model.dto.UserDto;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping("/api/user")
@FeignClient(name = "user")
public interface UserClient {

    @GetMapping(value = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    UserDto getOperation(@PathVariable("id") final String userId);

}

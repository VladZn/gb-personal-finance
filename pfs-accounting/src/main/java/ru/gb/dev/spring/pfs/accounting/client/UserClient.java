package ru.gb.dev.spring.pfs.accounting.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.dev.spring.pfs.accounting.model.dto.UserDto;

@RequestMapping("/api")
@FeignClient(name = "user")
public interface UserClient {

    @RequestMapping(value = "{id}", produces = "application/json", method = RequestMethod.GET)
    UserDto getOperation(@PathVariable("id") final String userId);

}

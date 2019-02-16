package ru.gb.dev.spring.pfs.accounting.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.dev.spring.pfs.accounting.model.dto.UserDto;

import java.util.List;

@RequestMapping("/api")
@FeignClient(name = "user")
public interface UsersClient {

    @RequestMapping(value = "/users", produces = "application/json", method = RequestMethod.GET)
    List<UserDto> getUsers();

}

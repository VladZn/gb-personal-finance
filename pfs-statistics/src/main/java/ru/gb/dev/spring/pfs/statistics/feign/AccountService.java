package ru.gb.dev.spring.pfs.statistics.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.dev.spring.pfs.statistics.model.dto.AccountDto;
import ru.gb.dev.spring.pfs.statistics.model.dto.util.ResultDto;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping("/api/accounts")
@FeignClient(name = "account")
public interface AccountService {

	@GetMapping(value = "/ping", produces = APPLICATION_JSON_UTF8_VALUE)
	ResultDto ping();


	@GetMapping(value = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
	AccountDto get(@PathVariable("id") final String id);

	@GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
	List<AccountDto> getAll();

	@PostMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE)
	ResultDto post(final AccountDto accountDto);

	@PutMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE)
	ResultDto put(final AccountDto accountDto);

	@DeleteMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE)
	ResultDto delete(final String accountId);

	@DeleteMapping(produces = APPLICATION_JSON_UTF8_VALUE)
	ResultDto deleteAll();

}

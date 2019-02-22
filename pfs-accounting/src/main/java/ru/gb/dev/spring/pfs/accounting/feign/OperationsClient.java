package ru.gb.dev.spring.pfs.accounting.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.dev.spring.pfs.accounting.model.dto.OperationDto;
import ru.gb.dev.spring.pfs.accounting.model.dto.util.ResultDto;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping("/api/operations")
@FeignClient(name = "operation")
public interface OperationsClient {

	@GetMapping(value = "/ping", produces = APPLICATION_JSON_UTF8_VALUE)
	ResultDto ping();

	@GetMapping(value = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
	OperationDto get(@PathVariable("id") final String id);

	@GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
	List<OperationDto> getAll();

	@PostMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	ResultDto post(final OperationDto operationDto);

	@PutMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	ResultDto put(final OperationDto operationDto);

	@DeleteMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	ResultDto delete(final String operationId);

	@DeleteMapping(produces = APPLICATION_JSON_UTF8_VALUE)
	ResultDto deleteAll();

}

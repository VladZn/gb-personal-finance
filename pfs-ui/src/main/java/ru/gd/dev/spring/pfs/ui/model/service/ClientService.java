package ru.gd.dev.spring.pfs.ui.model.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gd.dev.spring.pfs.ui.controller.dto.ResultDto;
import ru.gd.dev.spring.pfs.ui.model.dto.ClientDto;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping("/api/clients")
@FeignClient(name = "statistics")
public interface ClientService {

	@GetMapping(value = "/ping", produces = APPLICATION_JSON_UTF8_VALUE)
	ResultDto ping();

	@GetMapping(value = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
	ClientDto get(@PathVariable("id") final String id);

	@GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
	List<ClientDto> getAll();

	@PostMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	ResultDto post(final ClientDto clientDto);

	@PutMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	ResultDto put(final ClientDto clientDto);

	@DeleteMapping(
			value = "{id}",
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	ResultDto delete(@PathVariable("id") final String clientId);

	@DeleteMapping(produces = APPLICATION_JSON_UTF8_VALUE)
	ResultDto deleteAll();

}

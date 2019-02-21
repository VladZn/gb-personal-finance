package ru.gb.dev.spring.pfs.statistics.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.dev.spring.pfs.statistics.exception.EntityNotFoundException;
import ru.gb.dev.spring.pfs.statistics.model.dto.ClientDto;
import ru.gb.dev.spring.pfs.statistics.model.dto.util.ResultDto;
import ru.gb.dev.spring.pfs.statistics.model.dto.util.SuccessDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Client;
import ru.gb.dev.spring.pfs.statistics.model.service.ClientService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {

	private final ClientService service;

	private final ModelMapper modelMapper;

	@Autowired
	public ClientsController(final ClientService service, final ModelMapper modelMapper) {
		this.service = service;
		this.modelMapper = modelMapper;
	}

	@GetMapping(value = "/ping", produces = APPLICATION_JSON_UTF8_VALUE)
	public ResultDto ping() {
		return new SuccessDto();
	}

	@GetMapping(value = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
	public ClientDto get(@PathVariable("id") final String id) {
		return service.findById(id)
				.map(client -> modelMapper.map(client, ClientDto.class))
				.orElseThrow(() -> new EntityNotFoundException("Logo with id " + id + "not found"));
	}

	@GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
	public List<ClientDto> getAll() {
		final Iterable<Client> clients = service.findAll();
		return StreamSupport
				.stream(clients.spliterator(), false)
				.map(client -> modelMapper.map(client, ClientDto.class))
				.collect(Collectors.toList());
	}

	@PostMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	public ResultDto post(final ClientDto clientDto) {
		service.save(clientDto);
		return new ResultDto();
	}

	@PutMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	public ResultDto put(final ClientDto clientDto) {
		service.save(clientDto);
		return new ResultDto();
	}

	@DeleteMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	public ResultDto delete(final String clientId) {
		service.deleteById(clientId);
		return new ResultDto();
	}

	@DeleteMapping(produces = APPLICATION_JSON_UTF8_VALUE)
	public ResultDto deleteAll() {
		service.deleteAll();
		return new ResultDto();
	}

}

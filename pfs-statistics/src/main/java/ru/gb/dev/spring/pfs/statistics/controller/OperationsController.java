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
import ru.gb.dev.spring.pfs.statistics.model.dto.OperationDto;
import ru.gb.dev.spring.pfs.statistics.controller.dto.ResultDto;
import ru.gb.dev.spring.pfs.statistics.controller.dto.SuccessDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Operation;
import ru.gb.dev.spring.pfs.statistics.model.service.OperationService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/api/operations")
public class OperationsController {

	private final OperationService service;

	private final ModelMapper modelMapper;

	@Autowired
	public OperationsController(final OperationService service, final ModelMapper modelMapper) {
		this.service = service;
		this.modelMapper = modelMapper;
	}

	@GetMapping(value = "/ping", produces = APPLICATION_JSON_UTF8_VALUE)
	public ResultDto ping() {
		return new SuccessDto();
	}

	@GetMapping(value = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
	public OperationDto get(@PathVariable("id") final String id) {
		return service.findById(id)
				.map(operation -> modelMapper.map(operation, OperationDto.class))
				.orElseThrow(() -> new EntityNotFoundException("Logo with id " + id + "not found"));
	}

	@GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
	public List<OperationDto> getAll() {
		final Iterable<Operation> operations = service.findAll();
		return StreamSupport
				.stream(operations.spliterator(), false)
				.map(operation -> modelMapper.map(operation, OperationDto.class))
				.collect(Collectors.toList());
	}

	@PostMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	public ResultDto post(final OperationDto operationDto) {
		service.save(operationDto);
		return new ResultDto();
	}

	@PutMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	public ResultDto put(final OperationDto operationDto) {
		service.save(operationDto);
		return new ResultDto();
	}

	@DeleteMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	public ResultDto delete(final String operationId) {
		service.deleteById(operationId);
		return new ResultDto();
	}

	@DeleteMapping(produces = APPLICATION_JSON_UTF8_VALUE)
	public ResultDto deleteAll() {
		service.deleteAll();
		return new ResultDto();
	}

}

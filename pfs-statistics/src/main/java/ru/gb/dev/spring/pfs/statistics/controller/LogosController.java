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
import ru.gb.dev.spring.pfs.statistics.model.dto.LogoDto;
import ru.gb.dev.spring.pfs.statistics.model.dto.util.ResultDto;
import ru.gb.dev.spring.pfs.statistics.model.dto.util.SuccessDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;
import ru.gb.dev.spring.pfs.statistics.model.service.LogoService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping("/api/logos")
public class LogosController {

	private final LogoService service;

	private final ModelMapper modelMapper;

	@Autowired
	public LogosController(final LogoService service, final ModelMapper modelMapper) {
		this.service = service;
		this.modelMapper = modelMapper;
	}

	@GetMapping(value = "/ping", produces = APPLICATION_JSON_UTF8_VALUE)
	public ResultDto ping() {
		return new SuccessDto();
	}

	@GetMapping(value = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
	public LogoDto get(@PathVariable("id") final String id) {
		return service.findById(id)
				.map(logo -> modelMapper.map(logo, LogoDto.class))
				.orElseThrow(() -> new EntityNotFoundException("Logo with id " + id + "not found"));
	}

	@GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
	public List<LogoDto> getAll() {
		final Iterable<Logo> logos = service.findAll();
		return StreamSupport
				.stream(logos.spliterator(), false)
				.map(logo -> modelMapper.map(logo, LogoDto.class))
				.collect(Collectors.toList());
	}

	@PostMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	public ResultDto post(final LogoDto logoDto) {
		service.save(logoDto);
		return new ResultDto();
	}

	@PutMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	public ResultDto put(final LogoDto logoDto) {
		service.save(logoDto);
		return new ResultDto();
	}

	@DeleteMapping(
			consumes = APPLICATION_JSON_UTF8_VALUE,
			produces = APPLICATION_JSON_UTF8_VALUE
	)
	public ResultDto delete(final String logoId) {
		service.deleteById(logoId);
		return new ResultDto();
	}

	@DeleteMapping(produces = APPLICATION_JSON_UTF8_VALUE)
	public ResultDto deleteAll() {
		service.deleteAll();
		return new ResultDto();
	}

}

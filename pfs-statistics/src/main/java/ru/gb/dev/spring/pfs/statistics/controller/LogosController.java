package ru.gb.dev.spring.pfs.statistics.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.dev.spring.pfs.statistics.controller.dto.ResultDto;
import ru.gb.dev.spring.pfs.statistics.controller.dto.SuccessDto;
import ru.gb.dev.spring.pfs.statistics.exception.EntityNotFoundException;
import ru.gb.dev.spring.pfs.statistics.model.dto.LogoDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;
import ru.gb.dev.spring.pfs.statistics.model.service.LogoService;

import java.util.Optional;
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

    @RequestMapping
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(
                StreamSupport.stream(service.findAll().spliterator(), false)
                        .map(logo -> modelMapper.map(logo, LogoDto.class))
                        .toArray(), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody LogoDto logoDto) {
        service.save(logoDto);
        return new ResponseEntity<>("Logo is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@PathVariable("id") final String id, @RequestBody LogoDto logoDto) {
        Optional<Logo> optional = service.findById(id);
        if (!optional.isPresent()) return new ResponseEntity<>("Logo is not found", HttpStatus.NOT_FOUND);
        Logo logo = optional.get();
        logoDto.setId(id);
        logoDto.setCreated(logo.getCreated());
        logoDto.setUpdated(logo.getUpdated());
        service.save(logoDto);
        return new ResponseEntity<>("Logo is updated successfully", HttpStatus.OK);
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

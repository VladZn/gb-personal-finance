package ru.gb.dev.spring.pfs.statistics.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.dev.spring.pfs.statistics.controller.dto.SuccessDto;
import ru.gb.dev.spring.pfs.statistics.model.dto.LogoDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Logo;
import ru.gb.dev.spring.pfs.statistics.model.service.LogoService;

import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/logos")
public class LogosController {

    private final LogoService service;

    private final ModelMapper modelMapper;

    @Autowired
    public LogosController(LogoService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/ping")
    public ResponseEntity<Object> ping() {
        return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Object> getLogo(@PathVariable("id") String id) {
        return new ResponseEntity<>(
                service.findById(id)
                        .map(logo -> modelMapper.map(logo, LogoDto.class))
                        .orElseGet(LogoDto::new),
                HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity<Object> getAllLogo() {
        return new ResponseEntity<>(
                StreamSupport.stream(service.findAll().spliterator(), false)
                        .map(logo -> modelMapper.map(logo, LogoDto.class))
                        .toArray(),
                HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createLogo(@RequestBody LogoDto logoDto) {
        service.save(logoDto);
        return new ResponseEntity<>("Logo is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateLogo(@PathVariable("id") String id, @RequestBody LogoDto logoDto) {
        Optional<Logo> optional = service.findById(id);
        if (!optional.isPresent()) return new ResponseEntity<>("Logo is not found", HttpStatus.NOT_FOUND);
        Logo logo = optional.get();
        logoDto.setId(id);
        logoDto.setCreated(logo.getCreated());
        logoDto.setUpdated(logo.getUpdated());
        service.save(logoDto);
        return new ResponseEntity<>("Logo is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteLogo(@PathVariable("id") String logoId) {
        service.deleteById(logoId);
        return new ResponseEntity<>("Logo is deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAllLogo() {
        service.deleteAll();
        return new ResponseEntity<>("Logos are deleted successfully", HttpStatus.OK);
    }

}

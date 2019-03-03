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
import ru.gb.dev.spring.pfs.statistics.model.dto.OperationDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Operation;
import ru.gb.dev.spring.pfs.statistics.model.service.OperationService;

import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/operations")
public class OperationsController {

    private final OperationService service;

    private final ModelMapper modelMapper;

    @Autowired
    public OperationsController(OperationService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/ping")
    public ResponseEntity<Object> ping() {
        return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Object> getOperation(@PathVariable("id") String id) {
        return new ResponseEntity<>(
                service.findById(id)
                        .map(operation -> modelMapper.map(operation, OperationDto.class))
                        .orElseGet(OperationDto::new),
                HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity<Object> getAllOperation() {
        return new ResponseEntity<>(
                StreamSupport.stream(service.findAll().spliterator(), false)
                        .map(operation -> modelMapper.map(operation, OperationDto.class))
                        .toArray(),
                HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createOperation(@RequestBody OperationDto operationDto) {
        service.save(operationDto);
        return new ResponseEntity<>("Operation is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateOperation(@PathVariable("id") String id, @RequestBody OperationDto operationDto) {
        Optional<Operation> optional = service.findById(id);
        if (!optional.isPresent()) return new ResponseEntity<>("Operation is not found", HttpStatus.NOT_FOUND);
        Operation operation = optional.get();
        operationDto.setId(id);
        operationDto.setCreated(operation.getCreated());
        operationDto.setUpdated(operation.getUpdated());
        service.save(operationDto);
        return new ResponseEntity<>("Operation is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteOperation(@PathVariable("id") String operationId) {
        service.deleteById(operationId);
        return new ResponseEntity<>("Operation is deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAllOperation() {
        service.deleteAll();
        return new ResponseEntity<>("Operations are deleted successfully", HttpStatus.OK);
    }

}

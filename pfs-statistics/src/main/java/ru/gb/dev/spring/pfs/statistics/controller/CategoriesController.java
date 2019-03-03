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
import ru.gb.dev.spring.pfs.statistics.model.dto.CategoryDto;
import ru.gb.dev.spring.pfs.statistics.model.entity.Category;
import ru.gb.dev.spring.pfs.statistics.model.service.CategoryService;

import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private final CategoryService service;

    private final ModelMapper modelMapper;

    @Autowired
    public CategoriesController(CategoryService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/ping")
    public ResponseEntity<Object> ping() {
        return new ResponseEntity<>(new SuccessDto(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Object> getCategory(@PathVariable("id") String id) {
        return new ResponseEntity<>(
                service.findById(id)
                        .map(category -> modelMapper.map(category, CategoryDto.class))
                        .orElseGet(CategoryDto::new),
                HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity<Object> getAllCategory() {
        return new ResponseEntity<>(
                StreamSupport.stream(service.findAll().spliterator(), false)
                        .map(category -> modelMapper.map(category, CategoryDto.class))
                        .toArray(),
                HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createCategory(@RequestBody CategoryDto categoryDto) {
        service.save(categoryDto);
        return new ResponseEntity<>("Category is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCategory(@PathVariable("id") String id, @RequestBody CategoryDto categoryDto) {
        Optional<Category> optional = service.findById(id);
        if (!optional.isPresent()) return new ResponseEntity<>("Category is not found", HttpStatus.NOT_FOUND);
        Category category = optional.get();
        categoryDto.setId(id);
        categoryDto.setCreated(category.getCreated());
        categoryDto.setUpdated(category.getUpdated());
        service.save(categoryDto);
        return new ResponseEntity<>("Category is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCategory(@PathVariable("id") String categoryId) {
        service.deleteById(categoryId);
        return new ResponseEntity<>("Category is deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAllCategory() {
        service.deleteAll();
        return new ResponseEntity<>("Categories are deleted successfully", HttpStatus.OK);
    }

}

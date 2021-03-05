package by.tms.controller;

import by.tms.model.Category;
import by.tms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/category")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
}

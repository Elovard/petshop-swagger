package by.tms.controller;

import by.tms.model.Tag;
import by.tms.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/tag")
public class TagResource {

    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity<Tag> saveCategory(@RequestBody Tag tag){
        tagService.save(tag);
        return new ResponseEntity<>(tag, HttpStatus.CREATED);
    }
}

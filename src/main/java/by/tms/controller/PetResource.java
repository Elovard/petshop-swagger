package by.tms.controller;

import by.tms.model.Pet;
import by.tms.model.PetStatusEnum;
import by.tms.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/pet")
public class PetResource {

    @Autowired
    private PetService petService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pet> savePet(@Valid @RequestBody Pet pet) {
        petService.addPet(pet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("findByStatus")
    public ResponseEntity<List<Pet>> findByStatus(PetStatusEnum petStatusEnum) {
        List<Pet> byStatus = petService.getbyStatus(petStatusEnum);
        return new ResponseEntity<>(byStatus, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> findById(@Valid @PathVariable("id") long id) {
        Pet byStatus = petService.getById(id);
        if (byStatus != null) {
            return new ResponseEntity<>(byStatus, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pet> deleteById(@PathVariable("id") long id) {
        Pet byId = petService.getById(id);
        if (byId != null) {
            petService.removePetById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

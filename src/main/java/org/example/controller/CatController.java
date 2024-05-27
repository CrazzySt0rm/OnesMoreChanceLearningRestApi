package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.CatDTO;
import org.example.model.Cat;
import org.example.service.CatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class CatController {

    private final CatService catService;

    @PostMapping("/cat")
    public ResponseEntity createCat(@RequestBody CatDTO catDTO) {
        return new ResponseEntity<>(catService.createCat(catDTO), HttpStatus.OK);
    }

    @GetMapping("/cat")
    public ResponseEntity readAllCats() {
        return new ResponseEntity(catService.readAllCats(), HttpStatus.OK);
    }

    @PutMapping("/cat")
    public ResponseEntity updateCat(@RequestBody Cat cat) {
        return new ResponseEntity<>(catService.updateCat(cat), HttpStatus.OK);
    }

    @DeleteMapping("/cat/{id}")
    public HttpStatus deleteCats(@PathVariable(value = "id") Long id) {
        catService.deleteCats(id);
        return HttpStatus.OK;
    }
}

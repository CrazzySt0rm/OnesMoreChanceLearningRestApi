package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.DetailsDTO;
import org.example.model.Details;
import org.example.service.DetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class DetailsController {

    private final DetailsService detailsService;

    @PostMapping("/details")
    public ResponseEntity createDetails(@RequestBody DetailsDTO detailsDTO) {
        return new ResponseEntity<>(detailsService.createDetails(detailsDTO), HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity readAllDetails() {
        return new ResponseEntity<>(detailsService.readAllDetails(), HttpStatus.OK);

    }

    @PutMapping("/details")
    public ResponseEntity updateDetails(@RequestBody Details details) {
        return new ResponseEntity<>(detailsService.updateDetails(details), HttpStatus.OK);
    }

    @DeleteMapping("/details/{id}")
    public HttpStatus deleteDetails(@PathVariable(value = "id") Long id) {
        detailsService.deleteDetails(id);
        return HttpStatus.OK;
    }


}

package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.BrilliantDTO;
import org.example.model.Brilliant;
import org.example.service.BrilliantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class BrilliantController {

    private final BrilliantService brilliantService;

    @PostMapping()
    public ResponseEntity create(@RequestBody BrilliantDTO brilliantDTO) {
        return new ResponseEntity<>(brilliantService.createBrilliant(brilliantDTO), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity readAll() {
        return new ResponseEntity<>(brilliantService.readAllBrilliants(), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity update(@RequestBody Brilliant brilliant) {
        return new ResponseEntity<>(brilliantService.updateBrilliant(brilliant), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable(value = "id") Long id) {
        brilliantService.deleteBrilliant(id);
        return HttpStatus.OK;
    }
}

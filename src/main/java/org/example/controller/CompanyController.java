package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.CompanyDTO;
import org.example.model.Company;
import org.example.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/company")
    public ResponseEntity createCompany(@RequestBody CompanyDTO companyDTO) {
        return new ResponseEntity<>(companyService.createCompany(companyDTO), HttpStatus.OK);
    }

    @GetMapping("/company")
    public ResponseEntity readAllCompany() {
        return new ResponseEntity<>(companyService.readAllCompany(), HttpStatus.OK);
    }

    @PutMapping("/company")
    public ResponseEntity updateCompany(@RequestBody Company company) {
        return new ResponseEntity<>(companyService.updateCompany(company), HttpStatus.OK);
    }

    @DeleteMapping("/company/{id}")
    public HttpStatus deleteCompany(@PathVariable(value = "id") Long id) {
        companyService.deleteCompany(id);
        return HttpStatus.OK;
    }
}

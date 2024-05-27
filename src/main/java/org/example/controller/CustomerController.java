package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.CustomerDTO;
import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("customer")
    public ResponseEntity createCust(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerService.createCustomer(customerDTO), HttpStatus.OK);
    }

    @GetMapping("/customer")
    public ResponseEntity readAllCust() {
        return new ResponseEntity<>(customerService.readAllCustomers(), HttpStatus.OK);
    }

    @PutMapping("/customer")
    public ResponseEntity updateCust(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
    }

    @DeleteMapping("/customer/{id}")
    public HttpStatus deleteCust(@PathVariable(value = "id") Long id) {
        customerService.deleteCustomer(id);
        return HttpStatus.OK;
    }
}

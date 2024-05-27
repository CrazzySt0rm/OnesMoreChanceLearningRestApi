package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.CustomerDTO;
import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer createCustomer(CustomerDTO customerDTO) {
        return customerRepository.save(Customer.builder()
                .name(customerDTO.getName())
                .lastname(customerDTO.getLastname())
                .patronymic(customerDTO.getPatronymic())
                .money(customerDTO.getMoney())
                .build());
    }

    public List<Customer> readAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

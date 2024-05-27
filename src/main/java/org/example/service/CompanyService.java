package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.CompanyDTO;
import org.example.model.Company;
import org.example.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Company createCompany(CompanyDTO companyDTO) {
        return companyRepository.save(Company.builder()
                .name(companyDTO.getName())
                .totalNumberOfEmployees(companyDTO.getTotalNumberOfEmployees())
                .build());
    }

    public List<Company> readAllCompany() {
        return companyRepository.findAll();
    }

    public Company updateCompany(Company company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}

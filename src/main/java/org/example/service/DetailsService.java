package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.DetailsDTO;
import org.example.model.Details;
import org.example.repository.DetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DetailsService {

    private final DetailsRepository detailsRepository;

    public Details createDetails(DetailsDTO detailsDTO) {
        return detailsRepository.save(Details.builder()
                .country(detailsDTO.getCountry())
                .city(detailsDTO.getCity())
                .build());
    }

    public List<Details> readAllDetails() {
        return detailsRepository.findAll();
    }

    public Details updateDetails(Details details) {
        return detailsRepository.save(details);
    }

    public void deleteDetails(Long id) {
        detailsRepository.deleteById(id);
    }
}

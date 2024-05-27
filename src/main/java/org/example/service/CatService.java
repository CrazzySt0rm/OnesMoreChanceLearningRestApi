package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.CatDTO;
import org.example.model.Cat;
import org.example.repository.CatRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatService {

    private final CatRepository catRepository;

    public Cat createCat(CatDTO catDTO) {
        return catRepository.save(Cat.builder()
                .name(catDTO.getName())
                .weight(catDTO.getWeight())
                .color(catDTO.getColor())
                .build());
    }

    public List<Cat> readAllCats() {
        return catRepository.findAll();
    }

    public Cat updateCat(Cat cat) {
        return catRepository.save(cat);
    }

    public void deleteCats(Long id) {
        catRepository.deleteById(id);

    }
}

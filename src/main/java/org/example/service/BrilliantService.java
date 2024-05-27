package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.BrilliantDTO;
import org.example.model.Brilliant;
import org.example.repository.BrilliantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrilliantService {

    private final BrilliantRepository brilliantRepository;

    public Brilliant createBrilliant(BrilliantDTO brilliantDTO) {
        return brilliantRepository.save(Brilliant.builder()
                .name(brilliantDTO.getName())
                .weight(brilliantDTO.getWeight())
                .build());
    }

    public List<Brilliant> readAllBrilliants() {
        return brilliantRepository.findAll();
    }

    public Brilliant updateBrilliant(Brilliant brilliant) {
        return brilliantRepository.save(brilliant);
    }

    public void deleteBrilliant(Long id) {
        brilliantRepository.deleteById(id);

    }
}

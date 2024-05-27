package org.example.repository;

import org.example.model.Brilliant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrilliantRepository extends JpaRepository<Brilliant, Long> {

    @Override
    List<Brilliant> findAll();

    List<Brilliant> findByWeight(String weight);


}

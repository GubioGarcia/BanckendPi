package com.example.BackEndPi.repository;

import com.example.BackEndPi.entity.ColecaoJogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColecaoJogoRepository extends JpaRepository<ColecaoJogo, Long> {
}

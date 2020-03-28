package com.example.cardealerxml.repositories;

import com.example.cardealerxml.models.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
    Part findByNameAndPrice(String name, BigDecimal price);
}

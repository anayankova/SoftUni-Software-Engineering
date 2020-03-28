package com.example.cardealerxml.repositories;

import com.example.cardealerxml.models.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Supplier findByName(String name);

    List<Supplier> findAllByImporterFalse();
}

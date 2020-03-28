package example.cardealer.repositories;

import example.cardealer.domains.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {

    Supplier getById(Long id);

    @Query("select s from  Supplier s where s.importer = false")
    List<Supplier> getLocalSuppliers();
}

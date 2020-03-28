package example.cardealer.repositories;

import example.cardealer.domains.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part,Long> {

    Part getById(Long id);

    @Query("select p from Part p where p.name = 'Mondeo'")
    Part getPartsWithName();
}

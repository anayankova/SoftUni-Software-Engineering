package softuni.bandregister.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bandregister.entities.Band;

@Repository
public interface BandRepository extends JpaRepository<Band, Integer> {
}

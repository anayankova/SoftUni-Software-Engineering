package example.cardealer.repositories;

import example.cardealer.domains.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {

    @Query("select s from Sale s where s.discount = 15")
    Sale getSales();
}

package example.cardealer.repositories;

import example.cardealer.domains.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer getById(Long id);

    @Query("select c from Customer c order by c.birthDate,c.yongDriver desc")
    List<Customer> getCustomerOrderedByDate();

    @Query("select c,sum(s.car.price * (1-s.discount)) as overal from Customer c join Sales s on c.id = s.customer.id group by c.id having c.salesSet.size>0 order by overal desc , c.salesSet.size desc")
    List<Object[]> getCustomerWithCar();
}

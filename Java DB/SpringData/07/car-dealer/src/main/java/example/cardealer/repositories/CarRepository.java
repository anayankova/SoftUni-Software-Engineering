package example.cardealer.repositories;

import example.cardealer.domains.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    Car getById(Long id);

    @Query("select c from Car c where c.make = :carMake order by c.model,c.travelledDistance desc")
    List<Car> getCarsByMake(@Param("carMake")String make);

    @Query("select c from Car c where c.id >=1")
    List<Car> getAllCars();
}



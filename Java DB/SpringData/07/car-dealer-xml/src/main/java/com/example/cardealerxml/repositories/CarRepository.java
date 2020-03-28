package com.example.cardealerxml.repositories;

import com.example.cardealerxml.models.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByMakeAndModelAndTravelledDistance(String name, String model, Integer distance);

    @Query("SELECT c FROM Car AS c WHERE c.make = 'Toyota' ORDER BY c.model, c.travelledDistance DESC")
    List<Car> findAllByMake();

}

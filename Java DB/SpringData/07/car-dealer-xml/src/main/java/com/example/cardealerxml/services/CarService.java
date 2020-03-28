package com.example.cardealerxml.services;

import com.example.cardealerxml.models.dtos.CarSeedDto;
import com.example.cardealerxml.models.dtos.CarViewRootDto;
import com.example.cardealerxml.models.dtos.CarWithPartsViewRootDto;
import com.example.cardealerxml.models.entities.Car;

import java.util.List;

public interface CarService {
    void seedCars(List<CarSeedDto> carSeedDtos);

    Car getRandomCar();

    CarViewRootDto getAllCarsByMake();

    CarWithPartsViewRootDto getAllCarsWithParts();
}

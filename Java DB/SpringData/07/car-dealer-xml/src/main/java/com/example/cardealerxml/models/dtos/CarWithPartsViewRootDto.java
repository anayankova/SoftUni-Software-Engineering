package com.example.cardealerxml.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithPartsViewRootDto {

    @XmlElement(name = "car")
    private List<CarWithPartsViewDto> cars;

    public CarWithPartsViewRootDto() {
    }

    public List<CarWithPartsViewDto> getCars() {
        return cars;
    }

    public void setCars(List<CarWithPartsViewDto> cars) {
        this.cars = cars;
    }
}

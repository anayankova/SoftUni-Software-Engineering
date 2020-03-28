package com.example.cardealerxml.models.dtos;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithPartsViewDto {

    @XmlAttribute
    private String make;
    @XmlAttribute
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private Integer travelledDistance;
    @XmlElement(name = "parts")
    private PartViewRootDto parts;

    public CarWithPartsViewDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Integer travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public PartViewRootDto getParts() {
        return parts;
    }

    public void setParts(PartViewRootDto parts) {
        this.parts = parts;
    }
}

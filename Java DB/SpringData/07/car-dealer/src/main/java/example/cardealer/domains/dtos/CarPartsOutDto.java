package example.cardealer.domains.dtos;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarPartsOutDto {

    @XmlAttribute(name = "make")
    private String carMake;
    @XmlAttribute(name = "model")
    private String carModel;
    @XmlAttribute(name = "travelled-distance")
    private Long traveledDistance;

    @XmlElement(name = "parts")
    private PartOutRootDto partsList;

    public CarPartsOutDto() {
    }

    public CarPartsOutDto(String carMake, String carModel, Long traveledDistance, PartOutRootDto partsList) {
        this.carMake = carMake;
        this.carModel = carModel;
        this.traveledDistance = traveledDistance;
        this.partsList = partsList;
    }

    public PartOutRootDto getPartsList() {
        return partsList;
    }

    public void setPartsList(PartOutRootDto partsList) {
        this.partsList = partsList;
    }
}

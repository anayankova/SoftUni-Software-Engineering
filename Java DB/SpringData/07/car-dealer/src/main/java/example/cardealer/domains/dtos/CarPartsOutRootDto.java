package example.cardealer.domains.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarPartsOutRootDto {
    @XmlElement(name = "car")
    private List<CarPartsOutDto> carsOut;

    public CarPartsOutRootDto() {
    }

    public List<CarPartsOutDto> getCarsOut() {
        return carsOut;
    }

    public void setCarsOut(List<CarPartsOutDto> carsOutLost) {
        this.carsOut = carsOutLost;
    }
}

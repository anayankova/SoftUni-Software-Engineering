package example.cardealer.domains.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarSeedRootDto {
    @XmlElement(name = "car")
    private List<CarSeedDto> carsDtos;

    public CarSeedRootDto() {
    }

    public List<CarSeedDto> getCarsDtos() {
        return carsDtos;
    }

    public void setCarsDtos(List<CarSeedDto> carsDtos) {
        this.carsDtos = carsDtos;
    }
}

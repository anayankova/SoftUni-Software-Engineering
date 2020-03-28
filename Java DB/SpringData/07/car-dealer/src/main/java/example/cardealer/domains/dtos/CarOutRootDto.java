package example.cardealer.domains.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarOutRootDto {
    @XmlElement(name = "car")
    private List<CarOutDto> carsDto;

    public CarOutRootDto() {
    }

    public List<CarOutDto> getCarsDto() {
        return carsDto;
    }

    public void setCarsDto(List<CarOutDto> carsDto) {
        this.carsDto = carsDto;
    }
}

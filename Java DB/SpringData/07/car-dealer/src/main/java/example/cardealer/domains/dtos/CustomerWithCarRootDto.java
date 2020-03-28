package example.cardealer.domains.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerWithCarRootDto {
    @XmlElement(name = "customer")
    private List<CustomerWithCarOutDto> customersWithCar;

    public CustomerWithCarRootDto() {
    }

    public CustomerWithCarRootDto(List<CustomerWithCarOutDto> customersWithCar) {
        this.customersWithCar = customersWithCar;
    }

    public List<CustomerWithCarOutDto> getCustomersWithCar() {
        return customersWithCar;
    }

    public void setCustomersWithCar(List<CustomerWithCarOutDto> customersWithCar) {
        this.customersWithCar = customersWithCar;
    }
}

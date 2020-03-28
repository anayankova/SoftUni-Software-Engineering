package example.cardealer.domains.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersOutRootDto {

    @XmlElement(name = "customer")
    private List<CustomersOutDto> customersOutDtos;

    public CustomersOutRootDto() {
    }

    public List<CustomersOutDto> getCustomersOutDtos() {
        return customersOutDtos;
    }

    public void setCustomersOutDtos(List<CustomersOutDto> customersOutDtos) {
        this.customersOutDtos = customersOutDtos;
    }
}

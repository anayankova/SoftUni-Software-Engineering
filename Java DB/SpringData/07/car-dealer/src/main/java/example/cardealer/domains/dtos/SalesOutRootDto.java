package example.cardealer.domains.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesOutRootDto {
    @XmlElement(name = "sale")
    private List<SalesOutDto> salesMade;

    public SalesOutRootDto() {
    }

    public SalesOutRootDto(List<SalesOutDto> salesMade) {
        this.salesMade = salesMade;
    }

    public List<SalesOutDto> getSalesMade() {
        return salesMade;
    }

    public void setSalesMade(List<SalesOutDto> salesMade) {
        this.salesMade = salesMade;
    }
}

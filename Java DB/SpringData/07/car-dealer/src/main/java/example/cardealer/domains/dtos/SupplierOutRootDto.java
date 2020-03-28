package example.cardealer.domains.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierOutRootDto {

    @XmlElement(name = "suplier")
    List<SupplierOutDto> supplierOutDtos;

    public SupplierOutRootDto() {
    }

    public List<SupplierOutDto> getSupplierOutDtos() {
        return supplierOutDtos;
    }

    public void setSupplierOutDtos(List<SupplierOutDto> supplierOutDtos) {
        this.supplierOutDtos = supplierOutDtos;
    }
}

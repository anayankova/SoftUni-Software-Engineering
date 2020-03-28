package example.cardealer.domains.dtos;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartsSeedDto {
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "price")
    private BigDecimal price;
    @XmlAttribute(name = "quantity")
    private int quantity;

    public PartsSeedDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

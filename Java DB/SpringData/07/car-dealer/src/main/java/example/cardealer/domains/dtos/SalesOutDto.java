package example.cardealer.domains.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesOutDto {
    @XmlElement(name = "car")
    private CarSoldOutDto carSoldOutDto;
    @XmlElement(name = "customer-name")
    private String name;
    @XmlElement(name = "discount")
    private double discount;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public SalesOutDto() {
    }

    public SalesOutDto(CarSoldOutDto carSoldOutDto, String name, double discount, BigDecimal price, BigDecimal priceWithDiscount) {
        this.carSoldOutDto = carSoldOutDto;
        this.name = name;
        this.discount = discount;
        this.price = price;
        this.priceWithDiscount = priceWithDiscount;
    }

    public CarSoldOutDto getCarSoldOutDto() {
        return carSoldOutDto;
    }

    public void setCarSoldOutDto(CarSoldOutDto carSoldOutDto) {
        this.carSoldOutDto = carSoldOutDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}

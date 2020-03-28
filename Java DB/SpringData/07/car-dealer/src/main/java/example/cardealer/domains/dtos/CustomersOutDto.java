package example.cardealer.domains.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersOutDto {
    @XmlElement(name = "id")
    private Long id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "birth-date")
    private String birthDate;
    @XmlElement(name = "is-youn-driver")
    private boolean isYongDriver;

    public CustomersOutDto(){

    }

    public CustomersOutDto(Long id, String name, String birthDate, boolean isYongDriver) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.isYongDriver = isYongDriver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYongDriver() {
        return isYongDriver;
    }

    public void setYongDriver(boolean yongDriver) {
        isYongDriver = yongDriver;
    }

}

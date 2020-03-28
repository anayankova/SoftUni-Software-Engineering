package example.cardealer.domains.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    
    private String make;
    private String model;
    private Long travelledDistance;
    private Set<Part> partsSet;
    private Sale sale;
    private BigDecimal price;

    public Car() {
    }

    @Column(name = "make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "travelled_distance")
    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    @ManyToMany()
    @JoinTable(name = "parts_cars",joinColumns = @JoinColumn(name = "car_id"),
               inverseJoinColumns = @JoinColumn(name = "part_id"))
    public Set<Part> getPartsSet() {
        return partsSet;
    }

    public void setPartsSet(Set<Part> partsSet) {
        this.partsSet = partsSet;
    }

    @OneToOne(mappedBy = "car")
    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public BigDecimal getPrice() {
        BigDecimal calculation = new BigDecimal(0);
        for(Part p : this.getPartsSet()){
            calculation = calculation.add(p.getPrice());
        }
        return calculation;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

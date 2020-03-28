package example.cardealer.domains.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    private String name;
    private LocalDateTime birthDate;
    private boolean isYoungDriver;
    private Set<Sale> salesSet;

    public Customer() {
    }
    public Customer(String name,LocalDateTime date,boolean young){
        this.name = name;
        this.birthDate = date;
        this.isYoungDriver = young;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "birth_date")
    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "is_young_driver")
    public boolean isYongDriver() {
        return isYoungDriver;
    }

    public void setYongDriver(boolean yongDriver) {
        isYoungDriver = yongDriver;
    }

    @OneToMany(mappedBy = "customer")
    public Set<Sale> getSalesSet() {
        return salesSet;
    }

    public void setSalesSet(Set<Sale> salesSet) {
        this.salesSet = salesSet;
    }
}

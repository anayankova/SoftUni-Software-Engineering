package example.cardealer.domains.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity {

    private String name;
    private boolean isImporter;
    private Set<Part> partsSupply;

    public Supplier() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "is_importer")
    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }

    @OneToMany(mappedBy = "supplier")
    public Set<Part> getPartsSupply() {
        return partsSupply;
    }

    public void setPartsSupply(Set<Part> partsSupply) {
        this.partsSupply = partsSupply;
    }
}

package example.cardealer.domains.dtos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
public class PartsSeedRootDto {
    @XmlElement(name = "part")
    private List<PartsSeedDto> partsDtos;

    public PartsSeedRootDto() {
    }

    public List<PartsSeedDto> getParts() {
        return partsDtos;
    }

    public void setParts(List<PartsSeedDto> parts) {
        this.partsDtos = parts;
    }
}

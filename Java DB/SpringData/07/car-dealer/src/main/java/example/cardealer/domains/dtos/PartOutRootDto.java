package example.cardealer.domains.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartOutRootDto {
    @XmlElement(name = "part")
    private List<PartOutDto> partOutDtos;

    public PartOutRootDto() {
    }

    public List<PartOutDto> getPartOutDtos() {
        return partOutDtos;
    }

    public void setPartOutDtos(List<PartOutDto> partOutDtos) {
        this.partOutDtos = partOutDtos;
    }
}

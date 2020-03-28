package example.cardealer.services;

import example.cardealer.domains.entities.Part;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface PartsService {
    void seedParts() throws FileNotFoundException, JAXBException;
    Part getRandomPart();
}

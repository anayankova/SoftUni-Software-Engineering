package example.cardealer.utils;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XMLParser {
    <O> void exportToXml (O object,String filePath) throws JAXBException;

    <O> O importFromXml(Class<O> klazz, String filePath) throws JAXBException, FileNotFoundException;

}

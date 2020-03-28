package example.cardealer.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XMLParserImpl implements XMLParser {

    @Override
    public <O> void exportToXml(O object, String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(object, new File(filePath));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <O> O importFromXml(Class<O> klazz,String filePath) throws JAXBException, FileNotFoundException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(klazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (O)unmarshaller.unmarshal(new FileReader(filePath));
    }
}

package by.training.xmlparser.builder;

import by.training.xmlparser.entity.Medicine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

public class MedicinesSAXBuilder extends AbstractMedicinesBuilder {

    private static Logger log = LogManager.getLogger();
    private MedicineHandler sh;
    private XMLReader reader;

    public MedicinesSAXBuilder() {
        sh = new MedicineHandler();
        try {
            //creating a handler object
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(sh);
        } catch (SAXException e) {
            log.error("SAX parser error: " + e);
        }
    }

    public MedicinesSAXBuilder(Set<Medicine> medicines) {
        super(medicines);
    }
    @Override
    public void buildSetMedicines(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            log.error("SAX parser error: " + e);
        } catch (IOException e) {
            log.error("error I/O flow: " + e);
        }
        medicines = sh.getMedicines();
    }
}

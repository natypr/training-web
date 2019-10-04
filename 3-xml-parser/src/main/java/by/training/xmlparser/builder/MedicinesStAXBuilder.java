package by.training.xmlparser.builder;

import by.training.xmlparser.enm.MedicineEnum;
import by.training.xmlparser.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public class MedicinesStAXBuilder extends AbstractMedicinesBuilder {

    private static Logger log = LogManager.getLogger();
    private XMLInputFactory inputFactory;

    public MedicinesStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public MedicinesStAXBuilder(Set<Medicine> medicines) {
        super(medicines);
    }

    @Override
    public void buildSetMedicines(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;

        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (MedicineEnum.valueOf(name.toUpperCase()) == MedicineEnum.MEDICINE) {
                        Medicine md = buildMedicine(reader);
                        medicines.add(md);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            log.error("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            log.error("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                log.error("Impossible close file " + fileName + " : " + e);
            }
        }
    }

    private Medicine buildMedicine(XMLStreamReader reader) throws XMLStreamException {
        Medicine md = new Medicine();
        String nameAttr;
        for (int i = 0; i < 2;i++) {
            nameAttr = reader.getAttributeLocalName(i);
            switch (nameAttr){
                case "id":
                    md.setId(reader.getAttributeValue(null, MedicineEnum.ID.getValue()));
                    break;
                case "group":
                    md.setGroup(reader.getAttributeValue(null, MedicineEnum.GROUP.getValue()));
                    break;
            }
        }

        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (MedicineEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            md.setName(getXMLText(reader));
                            break;
                        case PHARM:
                            md.setPharm(getXMLText(reader));
                            break;
                        case ANALOGS:
                            md.setAnalogs(getXMLText(reader));
                        case MANUFACTURER:
                            md.setManufacturer(getXMLManufacturer(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineEnum.valueOf(name.toUpperCase()) == MedicineEnum.MEDICINE) {
                        return md;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Medicine. ");
    }

    private Manufacturer getXMLManufacturer(XMLStreamReader reader) throws XMLStreamException {
        Manufacturer mnf = new Manufacturer();
        mnf.setVersionn(reader.getAttributeValue(null, MedicineEnum.VERSIONN.getValue())); //
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName().replace("-", "_");
                    switch (MedicineEnum.valueOf(name.toUpperCase())) {
                        case CERTIFICATE:
                            Certificate cr = new Certificate();
                            cr.setNumber(Integer.parseInt(reader.
                                    getAttributeValue(null, MedicineEnum.NUMBER.getValue())));
                            cr.setIssueDate(reader
                                    .getAttributeValue(null, MedicineEnum.ISSUE_DATE.getValue()));
                            cr.setExpirationDate(reader
                                    .getAttributeValue(null, MedicineEnum.EXPIRATION_DATE.getValue()));
                            cr.setRegOrganization(reader
                                    .getAttributeValue(null, MedicineEnum.REG_ORGANISATION.getValue()));
                            break;
                        case PACKAGES:
                            Packages pc = new Packages();
                            pc.setQuantityInPackage(Integer.parseInt(reader.
                                    getAttributeValue(null, MedicineEnum.QUANTITY_IN_PACK.getValue())));
                            pc.setQuantityInPackage(Integer.parseInt(reader.
                                    getAttributeValue(null, MedicineEnum.PRICE.getValue())));
                            break;
                        case DOSAGE:
                            Dosage ds = new Dosage();
                            ds.setQuantityPerDay(Integer.parseInt(reader.
                                    getAttributeValue(null, MedicineEnum.QUANTITY_PER_DAY.getValue())));
                            ds.setPeriodOfUseDay(Integer.parseInt(reader.
                                    getAttributeValue(null, MedicineEnum.PERIOD_OF_USE_DAY.getValue())));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineEnum.valueOf(name.toUpperCase()) == MedicineEnum.MANUFACTURER){
                        return mnf;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Manufacturer. ");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}

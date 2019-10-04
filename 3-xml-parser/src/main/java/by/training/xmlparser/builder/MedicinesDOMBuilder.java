package by.training.xmlparser.builder;

import by.training.xmlparser.enm.MedicineEnum;
import by.training.xmlparser.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MedicinesDOMBuilder extends AbstractMedicinesBuilder {

    private static Logger log = LogManager.getLogger();
    private DocumentBuilder docBuilder;

    public MedicinesDOMBuilder() {
        this.medicines = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            log.info("Parser configuration error: " + e);
        }
    }

    public MedicinesDOMBuilder(Set<Medicine> medicines) {
        super(medicines);
    }

    @Override
    public void buildSetMedicines(String fileName) {
        Document doc = null;
        try {
            doc = docBuilder.parse(fileName);
            //everything, what between medicine
            Element root = doc.getDocumentElement();
            //getting a list of child elements <medicine>
            NodeList medicinesList = root.getElementsByTagName("medicine");
            for (int i = 0; i < medicinesList.getLength(); i++) {
                Element medicineElement = (Element) medicinesList.item(i);
                Medicine medicine = buildMedicine(medicineElement);
                medicines.add(medicine);
            }
        } catch (IOException e) {
            log.error("File error or I/O error: " + e);
        } catch (SAXException e) {
            log.error("Parsing failure: " + e);
        }
    }

    private Medicine buildMedicine(Element medicineElement) {
        Medicine medicine = new Medicine();
        NamedNodeMap name = medicineElement.getAttributes();
        for (int i = 0; i < name.getLength(); i++) {
            String t = name.toString();
            switch (t) {
                case "id":
                    medicine.setId(medicineElement.getAttribute(MedicineEnum.ID.getValue()));
                    break;
                case "group":
                    String tmp = MedicineEnum.GROUP.getValue();         //group
                    String temp = medicineElement.getAttribute(tmp);    //antibiotic
                    medicine.setGroup(temp);
                    break;
            }
        }

        medicine.setName(getElementTextContent(medicineElement, MedicineEnum.NAME.getValue()));
        medicine.setPharm(getElementTextContent(medicineElement, MedicineEnum.PHARM.getValue()));
        medicine.setAnalogs(getElementTextContent(medicineElement, MedicineEnum.ANALOGS.getValue()));

        Manufacturer manufacturer = medicine.getManufacturer();
        Element mnfElement = (Element) medicineElement
                .getElementsByTagName(MedicineEnum.MANUFACTURER.getValue()).item(0);

        manufacturer.setVersionn(medicineElement.getAttribute(MedicineEnum.VERSIONN.getValue())); //"tablets""

        Certificate certificate = new Certificate();
        certificate.setNumber(Integer.parseInt(medicineElement.getAttribute(MedicineEnum.NUMBER.getValue())));
        certificate.setIssueDate(medicineElement.getAttribute(MedicineEnum.ISSUE_DATE.getValue()));
        certificate.setExpirationDate(medicineElement.getAttribute(MedicineEnum.EXPIRATION_DATE.getValue()));
        certificate.setRegOrganization(medicineElement.getAttribute(MedicineEnum.REG_ORGANISATION.getValue()));

        Packages packages = new Packages();
        packages.setQuantityInPackage(Integer.parseInt(medicineElement
                .getAttribute(MedicineEnum.QUANTITY_IN_PACK.getValue())));
        packages.setPrice(Integer.parseInt(medicineElement
                .getAttribute(MedicineEnum.PRICE.getValue())));

        Dosage dosage = new Dosage();
        dosage.setQuantityPerDay(Integer.parseInt(medicineElement
                .getAttribute(MedicineEnum.QUANTITY_PER_DAY.getValue())));
        dosage.setPeriodOfUseDay(Integer.parseInt(medicineElement
                .getAttribute(MedicineEnum.PERIOD_OF_USE_DAY.getValue())));

        return medicine;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}

package by.training.xmlparser.builder;

import by.training.xmlparser.enm.MedicineEnum;
import by.training.xmlparser.entity.*;
import org.xml.sax.helpers.DefaultHandler;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.xml.sax.Attributes;

public class MedicineHandler extends DefaultHandler {

    private Set<Medicine> medicines;
    private Medicine current = null;
    private MedicineEnum currentEnum = null;
    private EnumSet<MedicineEnum> withText;

    public MedicineHandler() {
        medicines = new HashSet<Medicine>();
        withText = EnumSet.range(MedicineEnum.NAME, MedicineEnum.ANALOGS);
    }
    public Set<Medicine> getMedicines() {
        return medicines;
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs) {

        //simulation of the correct working code!

        if ("medicine".equals(localName)) {
            current = new Medicine();
            if (attrs.getLength() == 1) {
                current.setId(attrs.getValue(0));
            } else if ("group".equals(attrs.getValue(0))){
                current.setGroup(attrs.getValue(0));
                current.setId(attrs.getValue(1));
            } else {
                current.setId(attrs.getValue(0));
                current.setGroup(attrs.getValue(1));
            }
//            current.setId(attrs.getValue(0));
//            if (attrs.getLength() == 2) {
//                current.setGroup(attrs.getValue(1));
//            }
        } else {
            MedicineEnum temp = MedicineEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
            if (currentEnum != null) {
                switch (currentEnum) {
                    case MANUFACTURER:
                        Manufacturer manufacturer = new Manufacturer();
                        break;
                    case CERTIFICATE:
                        Certificate certificate = new Certificate();
                        certificate.setNumber(Integer.parseInt(attrs.getValue(MedicineEnum.NUMBER.getValue())));
                        certificate.setIssueDate(attrs.getValue(MedicineEnum.ISSUE_DATE.getValue()));
                        certificate.setExpirationDate(attrs.getValue(MedicineEnum.EXPIRATION_DATE.getValue()));
                        certificate.setRegOrganization(attrs.getValue(MedicineEnum.REG_ORGANISATION.getValue()));
                        break;
                    case PACKAGES:
                        Packages packages = new Packages();
                        packages.setQuantityInPackage(Integer.parseInt(attrs
                                .getValue(MedicineEnum.QUANTITY_IN_PACK.getValue())));
                        packages.setPrice(Integer.parseInt(attrs
                                .getValue(MedicineEnum.PRICE.getValue())));
                        break;
                    case DOSAGE:
                        Dosage dosage = new Dosage();
                        dosage.setQuantityPerDay(Integer.parseInt(attrs
                                .getValue(MedicineEnum.QUANTITY_PER_DAY.getValue())));
                        dosage.setPeriodOfUseDay(Integer.parseInt(attrs
                                .getValue(MedicineEnum.PERIOD_OF_USE_DAY.getValue())));
                }
            }
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if ("medicine".equals(localName)) {
            medicines.add(current);
        }
    }
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    current.setName(s);
                    break;
                case PHARM:
                    current.setPharm(s);
                    break;
                case ANALOGS:
                    current.setAnalogs(s);
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}

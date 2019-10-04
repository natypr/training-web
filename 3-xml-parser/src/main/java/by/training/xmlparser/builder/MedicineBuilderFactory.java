package by.training.xmlparser.builder;

public class MedicineBuilderFactory {

    private enum TypeParser {
        SAX, STAX, DOM
    }

    public AbstractMedicinesBuilder createMedicineBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new MedicinesDOMBuilder();
            case STAX:
                return new MedicinesStAXBuilder();
            case SAX:
                return new MedicinesSAXBuilder();
            default:
                throw new EnumConstantNotPresentException (type.getDeclaringClass(), type.name());
        }
    }
}

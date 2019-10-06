package by.training.parsing.jaxb;

import by.training.parsing.xmlstudents.Students;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Создание экземпляра класса на основе XML-документа.
 * В итоге будет получен корректно созданный экземпляр класса Students (вывод на консоль).
 */
public class UnMarshalMain {
    public static void main(String[ ] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Students.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("data/studs_marsh.xml");
            Students students = (Students) u.unmarshal(reader);
            System.out.println(students);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

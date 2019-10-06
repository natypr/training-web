package by.training.parsing.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import by.training.parsing.xmlstudents.Student;
import by.training.parsing.xmlstudents.Students;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/**
 * Создание XML-документа на основе экземпляра класса.
 * В результате компиляции и запуска программы будет создан studs_marsh.xml
 */
public class MarshalMain {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Students.class);
            Marshaller m = context.createMarshaller();
            Students st = new Students() { // анонимный класс
                {
                    // добавление первого студента
                    Student.Address addr = new Student.Address("BLR", "Minsk", "Skoriny 4");
                    Student s = new Student("gochette", "Klimenko", "mmf", 2095306, addr);
                    this.add(s);
                    // добавление второго студента
                    addr = new Student.Address("BLR", "Polotesk", "Simeona P. 23");
                    s = new Student("ivette", "Teran", "mmf", 2345386, addr);
                    this.add(s);
                }
            };
            m.marshal(st, new FileOutputStream("data/studs_marsh.xml"));
            m.marshal(st, System.out); // копия на консоль
            System.out.println("XML-файл создан");
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }
    }
}
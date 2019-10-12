package by.training.multithreading.runner;

import by.training.multithreading.entity.Person;
import by.training.multithreading.entity.Tavern;
import by.training.multithreading.filereader.DataFileReader;
import by.training.multithreading.thread.Group;
import com.google.common.collect.ImmutableList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Runner {

    private static final Logger LOG = LogManager.getLogger();

    public static void main(String[] args) throws InterruptedException {

        DataFileReader dataFileReader = new DataFileReader();
        List<String> list = dataFileReader.readFileOfData("data/data.txt");
        System.out.println(list);

        int numberOfHookahs = Integer.parseInt(list.get(0));
        Tavern tavern = new Tavern(numberOfHookahs);

        Person person;
        Group group = null;
        int listSize = list.size();
        for (int i = 1; i < listSize; i++) {
            person = new Person(list.get(i));
            group = new Group(i, ImmutableList.of(person));
        }
        System.out.println("Groups are entering..");
        for (int i = 1; i < listSize; i++) {
            tavern.admit(group);
        }
        System.out.println("All groups entered. Waiting for closing....");
        tavern.waitForClosing();
        System.out.println("Tavern is closed!.");
    }
}

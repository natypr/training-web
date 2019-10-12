package by.training.multithreading.entity;

import by.training.multithreading.thread.Group;
import com.google.common.collect.ImmutableList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TavernTest {
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    public void testTavern() throws InterruptedException {
        Person andy = new Person("Andy");
        Person bill = new Person("Bill");
        Person claire = new Person("Claire");
        Person daniel = new Person("Daniel");
        Person earl = new Person("Earl");
        Person fred = new Person("Fred");
        Person greg = new Person("Greg");
        Person harold = new Person("Harold");
        Person ian = new Person("Ian");
        Person john = new Person("John");
        Person kimmy = new Person("Kimmy");
        Person leonardo = new Person("Leonardo");
        Person mike = new Person("Mike");
        Person noah = new Person("Noah");

        int numberOfHookahs = 3;

        Tavern tavern = new Tavern(numberOfHookahs);
        Group group1 = new Group(1, ImmutableList.of(andy, bill, claire));
        Group group2 = new Group(2, ImmutableList.of(daniel, earl));
        Group group3 = new Group(3, ImmutableList.of(fred));
        Group group4 = new Group(4, ImmutableList.of(greg, harold, ian, john));
        Group group5 = new Group(5, ImmutableList.of(kimmy, leonardo));
        Group group6 = new Group(6, ImmutableList.of(mike, noah));

        LOGGER.info("Groups are entering.");
        tavern.admit(group1);
        tavern.admit(group2);
        tavern.admit(group3);
        tavern.admit(group4);
        tavern.admit(group5);
        tavern.admit(group6);
        LOGGER.info("All groups entered. Waiting for closing...");
        tavern.waitForClosing();
        LOGGER.info("Tavern is closed");
    }
}

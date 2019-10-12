package by.training.multithreading.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static java.util.Objects.requireNonNull;

public class Person {
    private static final Logger LOG = LogManager.getLogger();

    private final String name;

    public Person(String name) {
        this.name = requireNonNull(name, "name must be non-null");
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name != null ? name.equals(person.name) : person.name ==null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public Callable<Long> acquireAndUse(Hookah hookah) {
        return new PersonCallable(this, hookah);
    }

    private static final class PersonCallable implements Callable<Long> {
        private static final Logger LOG = LogManager.getLogger();
        private final Person person;
        private final Hookah hookah;

        public PersonCallable(Person person, Hookah hookah) {
            this.person = requireNonNull(person, "person must be non-null");
            this.hookah = requireNonNull(hookah, "hookah must be non-null");
        }

        @Override
        public Long call() {
            hookah.acquireLock();
            long ended = 0;
            long started = 0;
            try {
                //calculating the number of milliseconds to use a hookah.
                long durationMillis = ThreadLocalRandom.current().nextLong(1000, 5000);
                started = System.currentTimeMillis();
                LOG.info("{} started using hookah {}...", person.getName(), hookah.getId());
                TimeUnit.MILLISECONDS.sleep(durationMillis);
                LOG.info("{} stopped using hookah {}", person.getName(), hookah.getId());
                ended = System.currentTimeMillis();

            } catch (InterruptedException e) {
               LOG.error("Error in count of use the hookah: " + e);
            } finally {
                hookah.releaseLock();
            }
            return ended - started;
        }
    }
}

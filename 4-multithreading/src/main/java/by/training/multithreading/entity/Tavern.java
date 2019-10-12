package by.training.multithreading.entity;

import by.training.multithreading.thread.Group;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Tavern {
    private static final Logger LOG = LogManager.getLogger();
    private static ReentrantLock lock;

    private final Deque<Hookah> hookahs;
    private final Semaphore semaphore;
    private final ExecutorService executors;

    public Tavern(int numberOfHookahs) {
        hookahs = new ArrayDeque<>(numberOfHookahs);
        createHookahs(hookahs, numberOfHookahs);
        semaphore = new Semaphore(numberOfHookahs);
        executors = Executors.newFixedThreadPool(numberOfHookahs,
                new ThreadFactoryBuilder().setNameFormat("tavern-table-%d").build());
    }

    private static void createHookahs(Deque<Hookah> hookahs, int numberOfHookahs) {
        lock.lock();
        for (int i = 0; i < numberOfHookahs; i++) {
            hookahs.add(new Hookah(i));
        }
        lock.unlock();
    }

    //Add a group to the list of those wanting to get to a tavern
    public void admit(Group group) {
        LOG.info("Group {} is waiting outside...", group.getId());
        executors.submit(() -> {
            try {
                admitBlocking(group);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void admitBlocking(Group group) throws InterruptedException {
        semaphore.acquire();    //get one permission to access from the semaphore
        LOG.info("Group {} has entered the tavern...", group.getId());
        Hookah hookahToUse = hookahs.remove();
        try {
            group.useHookah(hookahToUse);
        } finally {
            hookahs.add(hookahToUse);
            semaphore.release();
            LOG.info("Group {} has left the tavern.", group.getId());
        }
    }

    public void waitForClosing() throws InterruptedException {
        executors.shutdown();
        executors.awaitTermination(1, TimeUnit.HOURS);
    }
}

package by.training.multithreading.thread;

import by.training.multithreading.entity.Hookah;
import by.training.multithreading.entity.Person;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.Objects.requireNonNull;

public class Group implements AutoCloseable {
    private static final Logger LOG = LogManager.getLogger();

    private final int id;
    private final List<Person> people;
    private final ExecutorService executors;

    public Group(int id, List<Person> people) {
        this.id = id;
        this.people = ImmutableList.copyOf(requireNonNull(people));
        executors = Executors.newFixedThreadPool(people.size(),
                new ThreadFactoryBuilder().setNameFormat("group" + id + "-person%d").build());
    }

    public int getId() {
        return id;
    }

    // People threads start concurrently competing for the resource (hookah).
    // The method will block until all of them complete.
    public void useHookah(Hookah hookah) {
        LOG.info("Group {} started using hookah {}...", id, hookah.getId());
        List<Future<Long>> futures = people.stream()
                .map(person -> executors.submit(person.acquireAndUse(hookah)))
                .collect(ImmutableList.toImmutableList());
        long totalTime = 0L;
        for (Future<Long> future : futures) {
            try {
                totalTime += future.get();
            } catch (InterruptedException | ExecutionException e) {
                LOG.error("The challenge is that this method needs to stop using hookah on error." + e);                // FIXME: handle or rethrow an error

            }
        }
        LOG.info("Group {} stopped using hookah {}. Total time spent: {}ms. Smoking kills!", id, hookah.getId(), totalTime);
    }

    @Override
    public void close() {
        executors.shutdownNow();
    }
}

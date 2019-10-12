package by.training.multithreading.entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hookah {
    private final int id;
    private final Lock lock = new ReentrantLock();

    public Hookah(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hookah hookah = (Hookah) o;
        return id == hookah.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    public void acquireLock() {
        lock.lock();
    }

    public void releaseLock() {
        lock.unlock();
    }
}

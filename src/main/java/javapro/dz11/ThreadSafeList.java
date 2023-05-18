package javapro.dz11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeList<T> {
    private final List<T> list;
    private final ReadWriteLock lock;

    public ThreadSafeList() {
        this.list = new ArrayList<>();
        this.lock = new ReentrantReadWriteLock();
    }

    public void add(T element) {
        lock.writeLock().lock();
        try {
            list.add(element);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void remove(T element) {
        lock.writeLock().lock();
        try {
            list.remove(element);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public T get(int index) {
        lock.readLock().lock();
        try {
            return list.get(index);
        } finally {
            lock.readLock().unlock();
        }
    }

    public int size() {
        lock.readLock().lock();
        try {
            return list.size();
        } finally {
            lock.readLock().unlock();
        }
    }
}

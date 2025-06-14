// QueueManager.java
package org.ahmet.classes;

import java.util.LinkedList;
import java.util.Queue;

public class QueueManager<T> {
    private Queue<T> queue = new LinkedList<>();

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return queue.poll();
    }

    public T peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
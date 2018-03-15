package main.java.edu.ucsb.cs56.projects.games.pokemon.systems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Stores system messages to be handled
 *
 * @author William Bennett
 */
// Every system has a shared reference to a SystemMessenger
public class SystemMessenger {
    Queue<SystemMessage> frontBuffer;
    Queue<SystemMessage> backBuffer;

    /**
     * Creates a SystemMessenger
     */
    public SystemMessenger() {
        frontBuffer = new ArrayDeque<>();
        backBuffer = new ArrayDeque<>();
    }

    /**
     * Dequeues the next SystemMessage
     *
     * @return the dequeued SystemMessage
     */
    public SystemMessage dequeue() {
        return frontBuffer.poll();
    }

    /**
     * Peeks the next SystemMessage, but does not dequeue
     *
     * @return the peeked SystemMessage
     */
    public SystemMessage peek() {
        return frontBuffer.peek();
    }

    /**
     * Enqueues a SystemMessage
     *
     * @param message the SystemMessage
     */
    public void enqueue(SystemMessage message) {
        backBuffer.offer(message);
    }

    /**
     * Merges the front buffer and back buffer
     */
    public void merge() {
        if (frontBuffer.size() > 0) {
            while (backBuffer.size() > 0) {
                frontBuffer.offer(backBuffer.poll());
            }
        }
        Queue<SystemMessage> tmp = frontBuffer;
        frontBuffer = backBuffer;
        backBuffer = tmp;
    }

    /**
     * Returns if the front buffer is empty
     *
     * @return if the front buffer is empty
     */
    public boolean isEmpty() {
        return (frontBuffer.size() == 0);
    }
}

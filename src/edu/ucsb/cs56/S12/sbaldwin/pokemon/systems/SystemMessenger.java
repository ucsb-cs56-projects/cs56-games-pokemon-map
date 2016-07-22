package edu.ucsb.cs56.S12.sbaldwin.pokemon.systems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by William Bennett on 7/21/2016.
 */
// Every system has a shared reference to a SystemMessenger
public class SystemMessenger {
    Queue<SystemMessage> frontBuffer;
    Queue<SystemMessage> backBuffer;

    public SystemMessenger() {
        frontBuffer = new ArrayDeque<>();
        backBuffer = new ArrayDeque<>();
    }

    public SystemMessage dequeue() {
        return frontBuffer.poll();
    }

    public SystemMessage peek() {
        return frontBuffer.peek();
    }

    public void enqueue(SystemMessage message) {
        backBuffer.offer(message);
    }

    public void merge() {
        if (frontBuffer.size() > 0) {
            while (backBuffer.size() > 0) {
                frontBuffer.offer(backBuffer.poll());
            }
        }
    }

    public boolean isEmpty() {
        return (frontBuffer.size() == 0);
    }
}

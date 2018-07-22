import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @Test
    void enQueue() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enQueue(1);
        queue.enQueue(2);
        assertEquals(1, (int)queue.deQueue());
        assertEquals(2, (int)queue.deQueue());

    }

    @Test
    void isEmpty() {
        MyQueue<Integer> queue = new MyQueue<>();
        assertTrue(queue.isEmpty());
    }
}
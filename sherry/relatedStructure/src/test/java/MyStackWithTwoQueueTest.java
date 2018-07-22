import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackWithTwoQueueTest {

    @Test
    void push() {
        MyStackWithTwoQueue<Integer> myStack = new MyStackWithTwoQueue<>();
        myStack.push(1);
        myStack.push(2);
        assertEquals(2, (int) myStack.top());
        myStack.pop();
        assertEquals(1, (int) myStack.top());
    }

    @Test
    void isEmpty() {
        MyStackWithTwoQueue<Integer> myStack = new MyStackWithTwoQueue<>();
        assertTrue(myStack.isEmpty());
    }

}
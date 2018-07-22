import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void pushAndTop() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        assertEquals(1, (int) stack.top());
        stack.push(2);
        assertEquals(2, (int) stack.top());
    }

    @Test
    void pop() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, (int) stack.pop());
        assertEquals(2, (int) stack.pop());
        assertEquals(1, (int) stack.pop());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.pop();
        });
    }

    @Test
    void isEmpty() {
        MyStack<Integer> stack = new MyStack<>();
        assertTrue(stack.isEmpty());
    }

}
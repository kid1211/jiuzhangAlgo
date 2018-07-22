import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class MyStackWithTwoQueue<E> {
    // the queue to hold all elements
    Queue<E> queue_first = new LinkedList<>();
    // the queue to accept poll items
    Queue<E> queue_second = new LinkedList<>();

    public void push(E e) {
        queue_first.offer(e);
    }

    public void pop() {
        moveItems();
        queue_first.poll();
        swapQueues();
    }

    public boolean isEmpty() {
        return queue_first.isEmpty();
    }

    public E top() {
        moveItems();
        E temp = queue_first.poll();
        queue_second.offer(temp);
        swapQueues();
        return temp;
    }

    private void moveItems() {
        while (queue_first.size() > 1) {
            queue_second.offer(queue_first.poll());
        }
    }

    private void swapQueues() {
        Queue<E> temp = queue_first;
        queue_first = queue_second;
        queue_second = temp;
    }
}

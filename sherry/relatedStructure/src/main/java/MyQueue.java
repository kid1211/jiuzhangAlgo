/**
 * @param <E>
 */
public class MyQueue<E> {

    // dummy.next = head
    // tail is the last node;
    // if dummy.next == null -> dummy = tail
    private QueueNode dummy, tail;

    public MyQueue() {
        dummy = new QueueNode(null);
        tail = dummy;
    }

    public void enQueue(E e) {
        QueueNode node = new QueueNode(e);
        // lastNode(next = null, val = 1)
        // 2 -> lastNode(next = 2, val = 1)
        // tail -> lastNode(next = null, val = 2)
        tail.next = node;
        tail = node;
    }

    public E deQueue() {
        QueueNode<E> temp = dummy.next;
        //System.out.println(temp.value);
        dummy = temp;

        if (dummy.next == null) {
            tail = dummy;// reset
        }
        return temp.value;
    }

    public boolean isEmpty() {
        return dummy.value == null;
    }

    public E peek() {
        QueueNode<E> temp = dummy.next;
        return temp.value;
    }
}

class QueueNode<E> {
    E value;
    QueueNode next;

    QueueNode(E value) {
        this.value = value;
    }
}

import java.util.ArrayList;

/**
 * This class implement the stack LIFO data structure
 *
 * @param <E>
 */
public class MyStack<E> {

    private ArrayList<E> internalStackList;
    private int currentPointer;

    public MyStack() {
        internalStackList = new ArrayList<>();
        currentPointer = -1;
    }

    public void push(E e) {
        internalStackList.add(e);
        currentPointer++;

    }

    public E pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return internalStackList.get(currentPointer--);
    }

    public boolean isEmpty() {
        return currentPointer < 0;
    }

    public E top() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return internalStackList.get(currentPointer);
    }
}

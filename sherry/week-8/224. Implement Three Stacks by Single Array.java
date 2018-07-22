// 224. Implement Three Stacks by Single Array
//
// Implement three stacks by single array.
//
// You can assume the three stacks has the same size and big enough, you don't need to care about how to extend it if one of the stack is full.
//
// Example
//
// ThreeStacks(5)  // create 3 stacks with size 5 in single array. stack index from 0 to 2
// push(0, 10) // push 10 in the 1st stack.
// push(0, 11)
// push(1, 20) // push 20 in the 2nd stack.
// push(1, 21)
// pop(0) // return 11
// pop(1) // return 21
// peek(1) // return 20
// push(2, 30)  // push 30 in the 3rd stack.
// pop(2) // return 30
// isEmpty(2) // return true
// isEmpty(0) // return false

public class ThreeStacks {
    int[] pointers;//, pointer2, pointer3;
    int[] list;
    int size;
    /*
    * @param size: An integer
    */public ThreeStacks(int size) {
        // do intialization if necessary
        list = new int[size*3];
        pointers = new int[3];
        pointers[0] = -1;
        pointers[1] = size-1;
        pointers[2] = size+size-1;
        this.size = size;
    }

    /*
     * @param stackNum: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void push(int stackNum, int value) {
        // Push value into stackNum stack
        pointers[stackNum]++;
        list[pointers[stackNum]] = value;
    }

    /*
     * @param stackNum: An integer
     * @return: the top element
     */
    public int pop(int stackNum) {
        // Pop and return the top element from stackNum stack
        int value = list[pointers[stackNum]];
        pointers[stackNum]--;
        return value;
    }

    /*
     * @param stackNum: An integer
     * @return: the top element
     */
    public int peek(int stackNum) {
        // Return the top element
        int value = list[pointers[stackNum]];
        return value;
    }

    /*
     * @param stackNum: An integer
     * @return: true if the stack is empty else false
     */
    public boolean isEmpty(int stackNum) {
        // write your code here
        return pointers[stackNum] <= size *stackNum -1;
    }
}

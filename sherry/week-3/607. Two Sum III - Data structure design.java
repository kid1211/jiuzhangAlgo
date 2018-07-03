// 607. Two Sum III - Data structure design
//
// Design and implement a TwoSum class. It should support the following operations: add and find.
//
// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the value.
//
// Example
//
// add(1); add(3); add(5);
// find(4) // return true
// find(7) // return false
// Input test data (one parameter per line.)
// TODO: Implement it using hash
// 
public class TwoSum {

    List<Integer> internalList = new ArrayList();

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        // insertion sort
        // bubble sort
        // ! heap sort
        // array move will caust O(n)
        // write your code here
        if(internalList.size() == 0) {
            internalList.add(number);
            return;
        }
        // put the num to target place;
        int targetIndex = getTargetIndex(number);
        //System.out.println("targetIndex: " + targetIndex);
        addNumToTargetPlace(targetIndex, number);
        //System.out.println(internalList);
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    // hash: O(n)
    // 2p: O(n)
    public boolean find(int value) {
        // write your code here
        int start = 0;
        int end = internalList.size() -1 ;
        while(start + 1 < end) {
            int temp = internalList.get(start) + internalList.get(end);
            if( temp== value) {
                return true;
            }
            if(temp < value) {
                start ++;
            }else {
                end --;
            }
        }
        if( internalList.get(start) + internalList.get(end) == value) {
            return true;
        }
        return false;
    }
]

    // don't need to use getTargetIndex-> bubble to get the location
    // find the first index >= target
    private int getTargetIndex (int number) {
        if(internalList.size() == 0) {
            return 0;
        }
        int start = 0;
        int end = internalList.size();

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(internalList.get(mid) == number) {
                return mid;
            }
            if(internalList.get(mid) < number) {
                start = mid;
            }else{
                end = mid;
            }
         }
         //[3, 5, 6] target 4 start = 3, end = 5 -> return end, start == 5, return start
         if(internalList.get(start) > number ) {
             return start;
         }
        return end;

    }

    private void addNumToTargetPlace (int targetIndex, int number) {
        int endIndex = internalList.size();
        //copy last num in end of array
        internalList.add(endIndex, internalList.get(endIndex -1));
        endIndex --;
        while (endIndex > targetIndex) {
            internalList.set(endIndex, internalList.get(endIndex -1)) ;
            endIndex --;
        }
        internalList.set(targetIndex, number);
    }
}

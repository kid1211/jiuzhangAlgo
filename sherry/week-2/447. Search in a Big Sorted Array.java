// 447. Search in a Big Sorted Array
//
// Given a big sorted array with positive integers sorted by ascending order. The array is so big so that you can not get the length of the whole array directly, and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.
//
// Return -1, if the number doesn't exist in the array.
//
// Example
//
// Given [1, 3, 6, 9, 21, ...], and target = 3, return 1.
//
// Given [1, 3, 6, 9, 21, ...], and target = 4, return -1.
//
// Challenge
//
// O(log k), k is the first index of the given target number.


public class Solution {
    /*
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        // get the start point using target to define
        int end = target;
        int start = 0;
        while(reader.get(end) < target) {
            start = target;
            end = end * 2;
        }

        //get the target
        int result = getTargetInRange(reader, start, end, target);
        return result;
    }

    private int getTargetInRange(ArrayReader reader, int start, int end, int target){
        while(start +1 < end) {
            int mid = start + (end - start) / 2;
            if(reader.get(mid) == target) {
                if((mid -1) < 0 || reader.get(mid -1) != target){
                    return mid;
                }
                end = mid;
            }
            if(reader.get(mid) < target) {
                start = mid;
            }else{
                end = mid;
            }
        }
        if(reader.get(start) == target) {
            return start;
        }
        if(reader.get(end) == target) {
            return end;
        }
        return -1;
    }
}

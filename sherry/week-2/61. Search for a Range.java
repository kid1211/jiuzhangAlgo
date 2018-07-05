// 61. Search for a Range
// Given a sorted array of n integers, find the starting and ending position of a given target value.
//
// If the target is not found in the array, return [-1, -1].
//
// Example
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].
//
// Challenge
// O(log n) time.

public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        // find left bound and left bound
        int[] result = {-1, -1};

        if(A == null || A.length == 0) {
            return result;
        }
        //get left bound
        int start = 0;
        int end = A.length -1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            }else {
                end = mid;
            }
        }
        if(A[start] == target) {
            result[0] = start;
        }else if (A[end] == target) {
            result[0] = end;
        }else {
            return result;
        }

        // find right bound
        end = A.length -1;
        while(start +1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] > target) {
                end = mid;
            }else{
                start = mid;
            }
        }
        if(A[end] == target) {
            result[1] = end;
        }else {
            result[1] = start;
        }

        return result;
    }
}

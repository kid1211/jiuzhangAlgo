// 75. Find Peak Element
//
// There is an integer array which has the following features:
//
// The numbers in adjacent positions are different.
// A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
// We define a position P is a peak if:
//
// A[P] > A[P-1] && A[P] > A[P+1]
// Find a peak element in this array. Return the index of the peak.
//
// Example
//
// Given [1, 2, 1, 3, 4, 5, 7, 6]
//
// Return index 1 (which is number 2) or 6 (which is number 7)
//
// Challenge
//
// Time complexity O(logN)
//TODO: need to double work -> copied result
public class Solution {
    /*
     * @param A: An integers array.
     * 
     * @return: return any of peek positions.
     */
    // TODO: this question looks note working
    public int findPeak(int[] A) {
        // write your code here
        int start = 1, end = A.length - 2; // 1.答案在之间，2.不会出界
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (A[mid] < A[mid - 1]) {
                end = mid;
            } else if (A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }
}
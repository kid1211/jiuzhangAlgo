// 460. Find K Closest Elements
//
// Given a target number, a non-negative integer k and an integer array A sorted in ascending order, find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target. Otherwise, sorted in ascending order by number if the difference is same.
//
// Example
//
// Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].
//
// Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].
//
// Challenge
//
// O(logn + k) time complexity.

public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        //edge cases
        if (A == null || A.length == 0) {
            // should return empty array instead of null
            return new int[0];
        }
        // Edge case not consider in first submit
        if (k == 0) {
            return new int[0];
        }
        // create an array with lengh K
        int[] resultArray = new int[k];
        //find nearest location
        int nearest = getNearestPosition(A, target);
        resultArray[0] = A[nearest];
        //System.out.println("the nearest point is: " + nearest);
        int left = nearest -1;
        int right = nearest +1;
        // maybe use while?
        for(int i = 1; i < k; i++) {
            // edge case
            if(left < 0){
                while(i<k){
                    resultArray[i] = A[right];
                    i++;
                    right++;
                }
                return resultArray;
            }
            if(right >= A.length){
                while(i<k){
                    resultArray[i] = A[left];
                    i++;
                    left--;
                }
                return resultArray;
            }
            if(Math.abs(A[left]-target) > Math.abs(A[right]-target)) {
                resultArray[i] = A[right];
                right++;
            }else{
                resultArray[i] = A[left];
                left--;
            }
        }
        return resultArray;
    }

    /*
     * Get the nearest location point using binery search
     */
     // OlogN
    private int getNearestPosition(int[] A, int target){
        int start = 0;
        int end = A.length - 1;
        int result = -1;
        while(start + 1 < end) {
            // avoid leak
            int mid = start + (end - start) / 2;
            if(A[mid] == target) {
                return mid;
            }
            if(A[mid] < target) {
                // [3,4,6,7] for mid point, it should > left <right
                if(A[mid + 1] > target) {
                   return Math.abs(A[mid]-target) <= Math.abs(A[mid + 1] - target ) ? mid : (mid + 1);
                }
                start = mid + 1;
            }else{
                end = mid;
            }
        }
       //System.out.println("the start point is: " + start);
       //System.out.println("the end point is: " + end);
        return Math.abs(A[start]-target) <= Math.abs(A[end] - target ) ? start : end;

    }
}

// 459. Closest Number in Sorted Array
//
// Given a target number and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to the given target.
//
// Return -1 if there is no element in the array.
//
// Example
//
// Given [1, 2, 3] and target = 2, return 1.
//
// Given [1, 4, 6] and target = 3, return 1.
//
// Given [1, 4, 6] and target = 5, return 1 or 2.
//
// Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2.
//
// Challenge
//
// O(logn) time complexity.
//
public class Solution {
    /*
     * @param A: an integer array sorted in ascending order
     * @param target: An integer
     * @return: an integer
     */
    public int closestNumber(int[] A, int target) {
        // write your code here
        //find diff using diff as target xxxooo target is diff,
        if(A == null || A.length == 0) {
            return -1;
        }

        int nearestLoc = getNeareastPoint(A, target);
        return nearestLoc;
    }

    private int getNeareastPoint(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        //int diff = Integer.MAX_VALUE;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target) {
                end = mid;
            }else{
                start = mid;
            }
        }

        return Math.abs(nums[start] - target) < Math.abs(nums[end] - target) ? start: end;
    }
}

// 458. Last Position of Target
//
// Find the last position of a target number in a sorted array. Return -1 if target does not exist.
//
// Example
//
// Given [1, 2, 2, 4, 5, 5].
//
// For target = 2, return 2.
//
// For target = 5, return 5.
//
// For target = 6, return -1.

public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length -1;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if(nums[right] == target) {
            return right;
        }

        if(nums[left] == target) {
            return left;
        }
        return -1;
    }
}

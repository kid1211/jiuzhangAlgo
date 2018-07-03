// 31. Partition Array
//
// Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
//
// All elements < k are moved to the left
// All elements >= k are moved to the right
// Return the partitioning index, i.e the first index i nums[i] >= k.
//
// Example
//
// If nums = [3,2,2,1] and k=2, a valid answer is 1.
//
// Challenge
//
// Can you partition the array in-place and in O(n)?
public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            while (start < end && nums[start] < k) {
                start++;
            }
            while (start < end && nums[end] >= k) {
                end--;
            }
            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;

                start ++;
                end --;
            }
        }
        // if(nums[start] >= k) {
        //     return start;
        // } else if(nums[end] < k) {
        //     return end + 1;
        // }
        return start;
    }
}

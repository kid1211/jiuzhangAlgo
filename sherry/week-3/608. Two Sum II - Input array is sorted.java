// 608. Two Sum II - Input array is sorted
//
// Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//
// The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
//
// Example
//
// Given nums = [2, 7, 11, 15], target = 9
// return [1, 2]
// hash -> target - x ? in map -> O(1)
//
public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        // edge cased
        if(nums == null || nums.length <= 1) {
            return new int[0];
        }
        int start = 0;
        int end = nums.length -1;
        while(start + 1 < end) {
            int temp = nums[start] + nums[end];
            if(temp == target) {
                return new int[]{start+1, end+1};
            }
            if(temp < target) {
                start++;
            }else{
                end--;
            }
        }

        if( nums[start] + nums[end] == target) {
           return new int[]{start+1, end+1};
        }
        return new int[0];
    }
}

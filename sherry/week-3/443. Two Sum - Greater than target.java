// 443. Two Sum - Greater than target
//
// Given an array of integers, find how many pairs in the array such that their sum is bigger than a specific target number. Please return the number of pairs.
//
// Example
//
// Given numbers = [2, 7, 11, 15], target = 24. Return 1. (11 + 15 is the only pair)
//
// Challenge
//
// Do it in O(1) extra space and O(nlogn) time.
public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        //for greater than target, if start + end > target, then end-start pair will greater
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        while(start < end) {
            int temp = nums[start] + nums[end];
            if(temp <=target) {
                start++;
            }else{
                count += end - start;
                end --;
            }
        }
        return count;
    }
}

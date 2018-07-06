// 587. Two Sum - Unique pairs
//
// Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number. Please return the number of pairs.
//
// Example
//
// Given nums = [1,1,2,45,46,46], target = 47
// return 2
//
// 1 + 46 = 47
// 2 + 45 = 47
public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        //edgecase
        if(nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        while (start < end) {
            int temp = nums[start] + nums[end];
            if (temp == target) {
                count++;
                //move pointer to next unequale position
                //TOOD: right way to move the pointer to right position
                while (start < end && nums[start] == nums[start + 1] ) {
                    start++;
                }
                while (start < end && nums[end] == nums[end - 1]) {
                    end--;
                }
                start++;
                end--;
            }else if(temp < target) {
                start++;
            }else{
                end--;
            }
        }
        return count;
    }
}

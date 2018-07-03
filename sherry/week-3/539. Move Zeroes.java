// 539. Move Zeroes
//
// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
// Example
//
// Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        // use two pointer
        // check edge case
        if(nums == null) {
            return;
        }

        int index = 0;
        int findPointer = 0;
        while(findPointer < nums.length) {
            while (findPointer < nums.length && nums[findPointer] == 0) {
                findPointer ++;
            }
            if(findPointer < nums.length) {
                nums[index] = nums[findPointer];
                index++;
                findPointer++;
            }
        }
        // is there a way to quick add Zero?
        //remove all index
        while(index<nums.length) {
            nums[index] = 0;
            index++;
        }

    }

}

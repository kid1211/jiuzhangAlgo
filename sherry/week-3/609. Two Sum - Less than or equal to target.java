// 609. Two Sum - Less than or equal to target
//
// Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number. Please return the number of pairs.
//
// Example
//
// Given nums = [2, 7, 11, 15], target = 24.
// Return 5.
// 2 + 7 < 24
// 2 + 11 < 24
// 2 + 15 < 24
// 7 + 11 < 24
// 7 + 15 < 25

public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here
        // edgecase
        if(nums == null || nums.length == 0) {
            return 0;
        }
        //sort the array
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length -1;
        int count = 0;
        //for target smaller than target, if end + start < target, then end-start pair could smaller than target move start [3,4,5, 6 ] 9
        //sould consider equal,
        while(start < end){
            int temp = nums[start] + nums[end] ;
            if(temp <=target) {
                count += end - start;
                start++;
            }else{
                end--;
            }
        }
        return count;

    }
}

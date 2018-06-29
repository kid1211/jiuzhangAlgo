// 585. Maximum Number in Mountain Sequence
//
// Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.
//
// Example
//
// Given nums = [1, 2, 4, 8, 6, 3] return 8
// Given nums = [10, 9, 8, 7], return 10
public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // write your code here
        //edge cases
        if(nums == null || nums.length == 0) {
            return -1;
        }
        // the code do not consider the edge case there's no peek in the code
        int left = 0;
        int right = nums.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left) /2;
            //System.out.println(nums[mid]);
            if(nums[mid] > nums[mid - 1]) {
                if(nums[mid] > nums[mid + 1]) {
                    return nums[mid];
                }
                left = mid;
            }else {
                right = mid;
            }
        }
        return ((nums[left] > nums[right]) ? nums[left] : nums[right]);
    }
}

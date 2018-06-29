// 159. Find Minimum in Rotated Sorted Array
//
// Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// Find the minimum element.
//
// Example
//
// Given [4, 5, 6, 7, 0, 1, 2] return 0
public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            //special case if the rotated happens on the index 0
            if(nums[mid] > nums[start] && nums[mid] < nums[end]) {
                return nums[start];
            }
            if(nums[mid] < nums[start]) {
                end = mid;
            }else {
                start = mid;
            }
            System.out.println("start: " + start);
            System.out.println("end: " + end);

        }
        return nums[start]<nums[end] ? nums[start]: nums[end] ;
    }
}

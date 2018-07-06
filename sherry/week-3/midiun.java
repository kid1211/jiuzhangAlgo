public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return helper(nums, 0, nums.length - 1, nums.length / 2 + nums.length %2);
    }
    private int helper(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int pos = partition(nums, left, right);
        if (pos + 1 == k) {
            return nums[pos];
        } else if (pos + 1 > k) {
            return helper (nums, left, pos - 1, k);
        } else {
            return helper (nums, pos + 1, right, k);
        }
    }
    private int partition (int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}

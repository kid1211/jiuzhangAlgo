
461. Kth Smallest Numbers in Unsorted Array

Find the kth smallest numbers in an unsorted integer array.

Example

Given [3, 4, 1, 2, 5], k = 3, the 3rd smallest numbers are [1, 2, 3].

Challenge

An O(nlogn) algorithm is acceptable, if you can do it in O(n), that would be great.

public class Solution {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        //solution: partition one time with random number x >= p-> right, x < p -> left
        //if j-start > k (start + k -1) <= j, partition left part, (start, j, k)
        // if start + k -1 >= i, partition right part, (i, end, k- i -start )
        // last, return end ?
        if(nums == null || nums.length == 0) {
            return -1;
        }
       return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {

        int pivot = nums[left];
        int i = left, j = right;
        while (i <= j) {
          //NOTE: nums[i] > pivot not >=
            while (i <= j && nums[i] < pivot) {
                i++;
            }
            while (i <= j && nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }

        if (left + k - 1 <= j) {
            return quickSelect(nums, left, j, k);
        }
        if (left + k - 1 >= i) {
            return quickSelect(nums, i, right, k - (i - left));
        }
        //NOTE: why hereis j+1 not j?
        return nums[j + 1];
    }
}

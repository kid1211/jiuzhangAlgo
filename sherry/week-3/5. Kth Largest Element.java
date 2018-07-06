// 5. Kth Largest Element
//
// Find K-th largest element in an array.
//
// Example
//
// In array [9,3,2,4,8], the 3rd largest element is 4.
//
// In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.
//
// Challenge
//
// O(n) time, O(1) extra memory.
class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        // quick sort with skip half
        // 1. find a pivot and sort, if start < k, -> start = left

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
            while (i <= j && nums[i] > pivot) {
                i++;
            }
            while (i <= j && nums[j] < pivot) {
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


public class Solution {
     public int findKthLargest(int[] nums, int k) {
         if (nums == null || nums.length == 0) {
             return -1;
         }
         return helper (nums, nums.length - k + 1, 0, nums.length - 1);
        //length - k + 1 convert the kth large to k'th small one
      }
     private int helper(int[] nums, int k, int start, int end) {
         if (start == end) {
             return nums[start];
         }

         int pos = partition(nums, start, end);
         if (pos + 1 == k) {
             return nums[pos];
         } else if (pos + 1 > k) {
             return helper (nums, k, start, pos - 1);
         } else {
             /*这个地方为什么是return 下一层递归的结果，因为需要的结果在下层／下下层递归中得到，
　　        把这个值返回来交给最上面的一层*/
             return helper (nums, k,  pos + 1, end);
         }

     }

     public int partition(int[] nums, int l, int r) {
        // 初始化左右指针和pivot
        int left = l, right = r;
        int pivot = nums[left];

        // 进行partition
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

        // 返还pivot点到数组里面
        nums[left] = pivot;
        return left;
    }
}

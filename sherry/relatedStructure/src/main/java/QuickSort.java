public class QuickSort {

    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public int median(int[] nums) {
        // write your code here
        if (nums == null) {
            return -1;
        }
        //if(nums.length % )
        //how to determin mid of an array?
        int mid = nums.length - nums.length / 2 + (nums.length % 2 == 1 ? 0 : 1);
        System.out.println(mid);
        return quickSelect(nums, 0, nums.length - 1, mid);
    }


    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        // get the pivot
        int pivot = nums[start + (end - start) / 2];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        //qick a interval to continue
        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }
        if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        }
        return nums[right + 1];
    }
}

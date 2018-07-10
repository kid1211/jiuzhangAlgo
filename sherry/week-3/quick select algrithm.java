Quick select算法描述

Input: array nums, int k. (find kth smallest element in an unsorted array)
Output: int target

Choose an element from the array as pivot, exchange the position of pivot and number at the end of the array.
The pivot can either be the end element or a random chosen element. A random chosen pivot can make the algorithm much possibly run in average case time.
Partition the array into 2 parts in which the numbers in left subarray is less than (or equal to) the pivot and the numbers in right subarray is greater than (or equal to) the pivot.
Exchange pivot (at the end of the array now) with the first element in the right part.
Compare k with length of the left subarray, say, len.
if k == len + 1， then pivot is the target.
if k <= len, repeat from step 1 on the left subarray.
if k > len, k = k - len, repeat from step 1 on the right subarray.

public class Solution {
    public int findKthSmallest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int len = nums.length;

        return quickSelect(nums, k, 0, len - 1);
    }

    private int quickSelect(int[] nums, int k, int start, int end) {

        //Choose a pivot randomly
        Random rand = new Random();
        int index = rand.nextInt(end - start + 1) + start;
        int pivot = nums[index];
        swap(nums, index, end);

        int left = start, right = end;

        while(left < right) {
            if (nums[left++] >= pivot) {
                swap(nums, --left, --right);
            }
        }
        //left is now pointing to the first number that is greater than or equal to the pivot
        swap(nums, left, end);

        //m is the number of numbers that is smaller than pivot
        int m = left - start;

        if (m == k - 1) { //in order to find the kth smallest number, there must be k - 1 number smaller than it
            return pivot;
        }
        else if (k <= m) { //target is in the left subarray
            return quickSelect(nums, k, start, left - 1);
        }
        else {
            //target is in the right subarray, but need to update k
            //Since we have discarded m numbers smaller than it which is in the right subarray
            return quickSelect(nums, k - m, left, end);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}


Quick Select复杂度分析

时间复杂度
完整的平均时间复杂度分析非常复杂，在这里不再赘述。有兴趣的可以看这里。
一般来说，因为我们才用了随机选取pivot的过程，平均来看，我们可以假设每次pivot都能选在中间位置。设算法时间复杂度为T(n)。在第一层循环中，我们将pivot与n个元素进行了比较，这个时间为cn 。
所以第一步时间为：T(n) = cnc + T(n/2)。其中T(n/2)为接下来递归搜索其中一半的子数组所需要的时间。
在递归过程中，我们可以得到如下公式：
T(n/2) = c(n/2) + T(n/4)
T(n/4) = c(n/4) + T(n/8)
...
T(2) = 2*c + T(1)
T(1) = 1*c
将以上公式循环相加消除T项可以得到：
T(n) = c(n + n/2 + n/4 + n/8 + ... + 2 + 1) = 2n = O(n)
因此得到Quick Select算法的时间复杂度为O(n)。

空间复杂度
算法没有使用额外空间，swap操作是inplace操作，所以算法的空间复杂度为O(1)。

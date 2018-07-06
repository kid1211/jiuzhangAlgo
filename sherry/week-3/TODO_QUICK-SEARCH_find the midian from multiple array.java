There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0


Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
暴力的方法： 每次取两个array的头一个元素进行比较，谁小谁出列，知道出列了总长度／2. 所以总的时间复杂度为o(k)

把线性时间复杂度再去做优化，只能是logn，如何把线性复杂度优化为logn呢？

涉及到binarysearch的第三层理解，每次做o(1)的操作之后，能保留一半解，也就是说把解的范围缩小一半。

附：binary search 笔记 https://i.cnblogs.com/EditPosts.aspx?postid=5875846



利用binary search / quick select的其思想，一次扔掉一半。

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int total = size1 + size2;
        if (total % 2 == 0) {
            return 0.5 * (helper(nums1, 0, nums2, 0, (total / 2) ) + helper(nums1, 0, nums2, 0, (total / 2) + 1));
        } else {
            return helper(nums1, 0, nums2, 0, (total / 2) + 1);
        }
    }
    private static int helper (int[] nums1, int start1,
                                int[] nums2, int start2,
                                int k) { //note k denotes the kth number, not the index!!!! eg total == 3 -> k == 2
       // if (start1 == nums1.length){
        if (start1 >= nums1.length){
            return nums2[start2 + k - 1];
        } else if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        } else if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int a_key = start1 + k/2  <= nums1.length ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int b_key = start2 + k/2 <= nums2.length ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (a_key > b_key) {
            return helper (nums1, start1, nums2,start2 + k/2, k - k/2);
        } else {
            return helper (nums1, start1 + k/2, nums2, start2, k - k/2);
        }
    }
}
好多好多坑：

1. 通过比较两个数组 a, b的第k/2个数，判断是丢掉a的k/2还是b的k/2。 每次丢掉k／2个数，通过o(1)的操作。总之，随小丢谁

2.两个数组，怎么来丢掉k/2的部分，对于数组来说，其实只要更新一下起始坐标就好了。记住从哪个位置开始是有效的。注意，标记的是起始的坐标，注意index与第xx个的转换。

3. 当a数组非常小，不够k／2个怎么办？

我们不能确保解不在a里面，但是能确保解不在b的k／2里面

那么我们就要扔掉b的前k/2个数，使用了maxValue的小技巧！！

4. 关于奇偶性的问题，总长度为奇数时候，下次层去找k - k/2个，比如 总个数是3， 只能扔掉1个，下一层去找前2个。

5. 递归的出口问题，helper函数里面有3组参数，针对每一组参数都有极限情况

　　a. A没有数了

　　b. b没有数了

　　c. k == 1

　　如果用下面这个判断的话，会出现下面的错误 if (start1 == nums1.length)

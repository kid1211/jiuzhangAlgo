
class Solution:
    cla """
    @param nums: The integer array you should partition
    @param k: An integer
    @return: The index after partition
    """

    def partitionArray(self, nums, k):
        # write your code here

        left = 0
        right = len(nums) - 1

        while left <= right:
            if nums[left] < k:
                left += 1
                continue
            if nums[right] >= k:
                right -= 1
                continue

            nums[left], nums[right] = nums[left], nums[right]
            left += 1
            right -= 1

        return left

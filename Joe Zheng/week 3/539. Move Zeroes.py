class Solution:
    """
    @param nums: an integer array
    @return: nothing
    """

    def moveZeroes(self, nums):
        # write your code here
        left = 0
        right = len(nums) - 1

        while(left + 1 < right):
            if(nums[left] == 0):
                del nums[left]
                nums.append(0)
                right -= 1
            else:
                left += 1

        if nums[left] == 0 and nums[right] != 0:
            nums[left], nums[right] = nums[right], nums[left]

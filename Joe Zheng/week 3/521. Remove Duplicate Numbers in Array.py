class Solution:
    """
    @param: nums: an array of integers
    @return: the number of unique integers
    """

    def deduplication(self, nums):
        # write your code here
        # mergeSort use extra space
        length = len(nums)
        if length <= 1:
            return length

        nums.sort()
        print(nums)
        # lastUnique start from 1 not 0, because the one is the
        # first duplicate if it is duplicate
        lastUnique = 1
        # no need to check the last one
        for i in range(1, len(nums)):
            # if you find the unqui pair, put it on the last unique
            if nums[i] != nums[i - 1]:
                nums[lastUnique] = nums[i]
                lastUnique += 1
        return lastUnique

# [1,1]
# [1,3,1,4,4,2]
# [1,1,1,1,1,1,1,1,1,1,1]
# [2,1,3,4,5,6,7,8,9,1,2,3,6,7,8,10,12,12]

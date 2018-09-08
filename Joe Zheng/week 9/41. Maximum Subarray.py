class Solution:
    """
    @param nums: A list of integers
    @return: A integer indicate the sum of max subarray
    """
    def maxSubArray(self, nums):
        # write your code here
        rSum = 0
        
        mini, maxi = 0, -sys.maxsize
        for num in nums:
            rSum += num
            maxi = max(maxi, rSum - mini)
            mini = min(rSum, mini)
        return maxi
        

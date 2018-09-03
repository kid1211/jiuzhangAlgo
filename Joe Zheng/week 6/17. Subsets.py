class Solution:
    """
    @param nums: A set of numbers
    @return: A list of lists
    """

    def subsets(self, nums):
        # write your code here
        self.res = []
        if nums is None:
            return self.res
        self.dfs(sorted(nums), [], 0)
        return self.res

    def dfs(self, nums, curtRes, startIndex):
        self.res.append(curtRes[:])

        for i in range(startIndex, len(nums)):
            # print(i)
            curtRes.append(nums[i])
            self.dfs(nums, curtRes, i + 1)
            curtRes.pop()

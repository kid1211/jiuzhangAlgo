class Solution:
    """
    @param nums: A set of numbers.
    @return: A list of lists. All valid subsets.
    """

    def subsetsWithDup(self, nums):
        # write your code here
        self.res = []
        self.hashSet = set()
        self.dfs(sorted(nums), [], 0)
        return self.res

    def dfs(self, nums, curtRes, startIndex):
        temp = curtRes[:]
        curtHash = hash(tuple(temp))
        if curtHash not in self.hashSet:
            self.hashSet.add(curtHash)
            self.res.append(curtRes[:])

        for i in range(startIndex, len(nums)):
            curtRes.append(nums[i])
            self.dfs(nums, curtRes, i + 1)
            curtRes.pop()

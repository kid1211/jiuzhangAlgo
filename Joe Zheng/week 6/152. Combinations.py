class Solution:
    """
    @param n: Given the range of numbers
    @param k: Given the numbers of combinations
    @return: All the combinations of k numbers out of 1..n
    """

    def combine(self, n, k):
        # write your code here
        self.res = []
        self.dfs([(i + 1) for i in range(n)], k, [])
        return self.res

    def dfs(self, nums, length, curtRes):
        if len(curtRes) == length:
            self.res.append(curtRes[:])
            return

        for i in range(len(nums)):
            # add, dfs, remove
            if len(nums) == 0:
                return
            curtRes.append(nums[i])
            self.dfs(nums[i + 1:], length, curtRes)
            curtRes.pop()

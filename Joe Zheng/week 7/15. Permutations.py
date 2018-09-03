class Solution:
    """
    @param: nums: A list of integers.
    @return: A list of permutations.
    """

    def permute(self, nums):
        # write your code here
        if not nums:
            return [[]]
        self.visited = [False for _ in range(len(nums))]
        self.res = []
        self.dfs(nums, [])
        return self.res

    def dfs(self, nums, curt):
        if len(nums) == len(curt):
            self.res.append(curt[:])
            return

        for i in range(len(nums)):
            if self.visited[i]:
                continue
            curt.append(nums[i])
            self.visited[i] = True
            self.dfs(nums, curt)
            self.visited[i] = False
            curt.pop()

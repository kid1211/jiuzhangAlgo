class Solution:
    """
    @param: :  A list of integers
    @return: A list of unique permutations
    """

    def permuteUnique(self, nums):
        # write your code here
        if not nums:
            return [[]]

        self.res = []
        self.visited = [False for _ in nums]
        self.dfs(sorted(nums), [])
        return self.res

    def dfs(self, nums, curt):
        if len(nums) == len(curt):
            self.res.append(curt[:])
            return

        for i in range(len(nums)):
            if self.visited[i]:
                continue
            if i > 0 and nums[i] == nums[i - 1] and not self.visited[i - 1]:
                continue
            curt.append(nums[i])
            self.visited[i] = True
            self.dfs(nums, curt)
            self.visited[i] = False
            curt.pop()

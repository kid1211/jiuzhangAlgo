class Solution:
    """
    @param num: Given the candidate numbers
    @param target: Given the target number
    @return: All the combinations that sum to target
    """

    def combinationSum2(self, num, target):
        # write your code here
        self.res = []
        self.comb = set()
        num.sort()
        self.dfs(num, target, [], 0)
        return sorted(self.res)

    def dfs(self, num, target, curtRes, curtSum):
        length = len(num)
        if curtSum is target:
            temp = sorted(curtRes[:])
            curtHash = hash(tuple(temp))
            if curtHash not in self.comb:
                self.comb.add(curtHash)
                self.res.append(temp)
            return
        # add, dfs, remove
        for i in range(length):
            if curtSum + num[i] > target:
                return
            curtRes.append(num[i])
            curtSum += num[i]
            # print(curtRes)
            # print(num[i])
            # print('\n')
            self.dfs(num[:i], target, curtRes, curtSum)
            lastItem = curtRes.pop()
            curtSum -= lastItem
            # curtRes = []

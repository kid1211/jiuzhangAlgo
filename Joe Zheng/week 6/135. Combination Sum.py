class Solution:
    """
    @param candidates: A list of integers
    @param target: An integer
    @return: A list of lists of integers
    """

    def combinationSum(self, candidates, target):
        # write your code here
        self.res = []
        self.hashSet = set()
        self.dfs(sorted(candidates), target, [], 0)
        return self.res

    def dfs(self, canadiates, target, curtRes, curtSum):
        if curtSum == target:
            temp = sorted(curtRes[:])
            tempHash = hash(tuple(temp))
            if tempHash not in self.hashSet:
                self.hashSet.add(tempHash)
                self.res.append(temp)
            return

        for i in range(len(canadiates)):
            if curtSum + canadiates[i] > target:
                return
            curtRes.append(canadiates[i])
            curtSum += canadiates[i]
            self.dfs(canadiates, target, curtRes, curtSum)
            curtRes.pop()
            curtSum -= canadiates[i]

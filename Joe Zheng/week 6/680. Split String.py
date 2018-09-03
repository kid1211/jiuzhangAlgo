class Solution:
    """
    @param: : a string to be split
    @return: all possible split string array
    """

    def splitString(self, s):
        # write your code here
        # startIndex
        self.res = []
        self.dfs(s, [])
        return self.res

    def dfs(self, s, curtRes):
        if len(s) is 0:
            self.res.append(curtRes[:])  # need to make a new copy [:]
            return

        for i in [1, 2]:
            if i <= len(s):
                # add
                curtRes.append(s[:i])
                # dfs
                self.dfs(s[i:], curtRes)
                # remove
                curtRes.pop()

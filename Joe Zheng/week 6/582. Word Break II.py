class Solution:
    """
    @param: s: A string
    @param: wordDict: A set of words.
    @return: All possible sentences.
    """

    def wordBreak(self, s, wordDict):
        # write your code here
        return self.dfs(s, wordDict, {})

    def dfs(self, s, wordDict, memo):
        if s in memo:
            return memo[s]
        res = []
        if not s:
            return res

        length = len(s)

        if s in wordDict:
            res.append(s)

        for i in range(1, len(s)):
            if s[:i] not in wordDict:
                continue
            for sg in self.dfs(s[i:], wordDict, memo):
                res.append(s[:i] + " " + sg)

        memo[s] = res
        return res

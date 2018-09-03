class Solution:
    """
    @param str: A string
    @return: all permutations
    """

    def stringPermutation2(self, str):
        # write your code here
        if not str:
            return [""]
        self.visited = [False for _ in range(len(str))]

        self.res = []
        self.dfs(sorted(str), [])
        return self.res

    def dfs(self, str, curt):
        if len(str) == len(curt):
            self.res.append(''.join(curt))
            return

        for i in range(len(str)):
            if self.visited[i]:
                continue
            if i > 0 and str[i] == str[i - 1] and not self.visited[i - 1]:
                continue
            curt.append(str[i])
            self.visited[i] = True
            self.dfs(str, curt)
            self.visited[i] = False
            curt.pop()
# aaacacabbcbcc

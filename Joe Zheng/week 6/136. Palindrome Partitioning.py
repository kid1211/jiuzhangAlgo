class Solution:
    """
    @param: s: A string
    @return: A list of lists of string
    """

    def partition(self, s):
        # write your code here

        # print(self.isPali('bbab'))
        # return []
        self.res = []
        self.dfs(s, [])
        return self.res

    def dfs(self, s, curtRes):
        if len(s) == 0:
            self.res.append(curtRes[:])
            return

        for i in range(1, len(s) + 1):
            # add, dfs, remove
            if self.isPali(s[:i]) == False:
                continue
            curtRes.append(s[:i])
            self.dfs(s[i:], curtRes)
            curtRes.pop()

    def isPali(self, s):
        length = len(s)
        if length == 0:
            return True

        left, right = 0, length - 1
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return s[left] == s[right]

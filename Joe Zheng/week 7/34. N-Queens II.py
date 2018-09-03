class Solution:
    """
    @param n: The number of queens.
    @return: The total number of distinct solutions.
    """

    def totalNQueens(self, n):
        # write your code here
        if n <= 0:
            return 0
        self.res = 0
        self.dfs(n, [])
        return self.res

    def dfs(self, n, curt):
        if len(curt) == n:
            self.res += 1
            return
        for col in range(n):
            if not self.isValid(curt, col):
                continue
            curt.append(col)
            self.dfs(n, curt)
            curt.pop()

    def isValid(self, curt, col):
        currentRow = len(curt)
        # no need to check horizontal, because of the wy of generating the array
        for i in range(currentRow):
            if curt[i] == col:
                return False
            if abs(curt[i] - col) == abs(i - currentRow):
                return False
        return True

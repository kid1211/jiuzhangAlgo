class Solution:
    """
    @param: n: The number of queens
    @return: All distinct solutions
    """

    def solveNQueens(self, n):
        # write your code here
        if n <= 0:
            return [[]]
        self.res = []
        self.dfs(n, [])
        return self.res
        pass

    def dfs(self, n, curt):
        if len(curt) == n:
            self.res.append(self.printBoard(curt))
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

    def printBoard(self, board):
        length = len(board)
        res = []
        for i in range(length):
            tmp = ""
            for j in range(length):
                if board[i] == j:
                    tmp += 'Q'
                else:
                    tmp += '.'
            res.append(tmp)
        return res

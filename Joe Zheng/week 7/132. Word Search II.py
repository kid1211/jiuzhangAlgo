class Solution:
    """
    @param board: A list of lists of character
    @param words: A list of string
    @return: A list of string
    """

    def wordSearchII(self, board, words):
        # write your code here
        if board is None or words is None:
            return
        m = len(board)
        n = len(board[0])
        self.res = set()
        self.prefix_set = set()
        self.word_set = set(words)
        for word in words:
            for i in range(len(word)):
                self.prefix_set.add(word[:i + 1])

        for i in range(m):
            for j in range(n):
                self.dfs(board, board[i][j], i, j, set([(i, j)]))
        return list(self.res)

    def dfs(self, board, curt, row, col, visited):
        if curt not in self.prefix_set:
            return

        if curt in self.word_set:
            self.res.add(curt)

        moveTable = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        for dx, dy in moveTable:
            _x, _y = row + dx, col + dy

            if not self.valid(board, _x, _y):
                continue
            if (_x, _y) in visited:
                continue
            visited.add((_x, _y))
            self.dfs(board, curt + board[_x][_y], _x, _y, visited)
            visited.remove((_x, _y))

    def valid(self, board, x, y):
        return x >= 0 and x < len(board) and y >= 0 and y < len(board[0])

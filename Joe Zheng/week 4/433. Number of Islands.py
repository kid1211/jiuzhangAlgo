class Solution:
    # @param {boolean[][]} grid a boolean 2D matrix
    # @return {int} an integer
    def numIslands(self, grid):
        # Write your code here
        m = len(grid)
        if m == 0:
            return 0
        n = len(grid[0])
        visit = [[False for i in range(n)]for j in range(m)]

        def check(x, y):
            if x >= 0 and x < m and y >= 0 and y < n and grid[x][y] and visit[x][y] == False:
                return True

        def bfs(x, y):
            nbrow = [1, 0, -1, 0]
            nbcol = [0, 1, 0, -1]
            q = [(x, y)]
            while len(q) > 0:
                x = q[0][0]
                y = q[0][1]
                q.pop(0)
                for k in range(4):
                    newx = x + nbrow[k]
                    newy = y + nbcol[k]
                    if check(newx, newy):
                        visit[newx][newy] = True
                        q.append((newx, newy))

        count = 0
        for row in range(m):
            for col in range(n):
                if check(row, col):
                    visit[row][col] = True
                    bfs(row, col)
                    count += 1
        return count

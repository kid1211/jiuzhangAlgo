class Solution:
    """
    @param grid: a boolean 2D matrix
    @return: an integer
    """

    def numIslands(self, grid):
        # write your code here

        # exception
        # number of rows
        r = len(grid)
        if r == 0:
            return 0
        # number of coloumns
        c = len(grid[0])

        visited = [[False for _ in range(c)] for __ in range(r)]
        # print(visited)

        """
        check outofbound, if it is 1, if it is visited
        @param row and col: index to the location
        @return: Boolean 
        """
        def check(row, col):
            # print(row >= 0 and row < r)
            # print(col >= 0 and col < c)
            return (row >= 0 and row < r and
                    col >= 0 and col < c and
                    grid[row][col] and visited[row][col] == False)
        """
        mark the one's negibhor visited
        @param row and col: index to the location
        @return: nothing, 
        """
        def bfs(row, col):
            travers = [
                (1, 0),
                (0, 1),
                (-1, 0),
                (0, -1)
            ]

            # points that need to be traversed
            points = [(row, col)]
            while len(points) > 0:
                # take out the first one in that queue
                _x = points[0][0]
                _y = points[0][1]
                points.pop(0)
                for i in range(4):
                    newx = _x + travers[i][0]
                    newy = _y + travers[i][1]
                    if check(newx, newy):
                        # set the point to be visted, also add it into the queue
                        # to continue travers
                        print((newx, newy))
                        visited[newx][newy] = True
                        points.append((newx, newy))

        counts = 0
        # find all 1
        for row in range(r):
            for col in range(c):
                if check(row, col):
                    # c.append((row, col))
                    visited[row][col] = True
                    bfs(row, col)
                    counts += 1
        return counts

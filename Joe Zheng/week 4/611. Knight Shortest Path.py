"""
Definition for a point.
class Point:
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b
"""


class Solution:
    """
    @param grid: a chessboard included 0 (false) and 1 (true)
    @param source: a point
    @param destination: a point
    @return: the shortest path 
    """

    def shortestPath(self, grid, source, destination):
        # write your code here
        if grid == None:
            return -1
        rows = len(grid)
        cols = len(grid[0])
        if rows <= 0 or cols <= 0:
            return -1

        # print(visited)

        def checkValidMove(x, y):
            return (x >= 0 and x < cols and
                    y >= 0 and y < rows and
                    grid[x][y] == 0)

        import Queue
        queue = Queue.Queue(maxsize=rows * cols)
        queue.put(source)
        steps = [(1, 2), (1, -2), (-1, 2), (-1, -2),
                 (2, 1), (2, -1), (-2, 1), (-2, -1)]
        counts = 0
        while not queue.empty():
            head = queue.get()
            if (head.x, head.y) == (destination.x, destination.y):
                break
            for step in steps:
                newx = head.x + step[0]
                newy = head.y + step[1]
                if checkValidMove(newx, newy):
                    # counts += 1
                    grid[newx][newy] = 1
                    queue.put((newx, newy))
            counts += 1

        if counts > 0:
            return counts
        return -1

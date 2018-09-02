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

        print('rows: ' + str(rows))
        print('cols: ' + str(cols))
        # print(visited)
        # print(grid[4][6])

        def checkValidMove(x, y):
            # print((x,y))
            return (x >= 0 and x < rows and
                    y >= 0 and y < cols and
                    grid[x][y] == 0)

        import queue
        q = queue.Queue(maxsize=rows * cols)

        q.put(source)
        deltas = [
            Point(1, 2),
            Point(1, -2),
            Point(-1, 2),
            Point(-1, -2),
            Point(2, 1),
            Point(2, -1),
            Point(-2, 1),
            Point(-2, -1)]

        counts = 0

        while not q.empty():
            qSize = q.qsize()
            for _ in range(qSize):
                head = q.get()
                # print(type(head))
                # print(type(source))
                # print(type(destination))
                if (head.x, head.y) == (destination.x, destination.y):
                    return counts
                for d in deltas:
                    newx = head.x + d.x
                    newy = head.y + d.y
                    if checkValidMove(newx, newy):
                        # counts += 1
                        grid[newx][newy] = 1
                        q.put(Point(newx, newy))
            counts += 1

        return -1

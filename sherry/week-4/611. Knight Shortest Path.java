/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

// (x + 1, y + 2)
// (x + 1, y - 2)
// (x - 1, y + 2)
// (x - 1, y - 2)
// (x + 2, y + 1)
// (x + 2, y - 1)
// (x - 2, y + 1)
// (x - 2, y - 1)
//
// not working
public class Solution {


    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        //edge case
        if(source == null || destination == null || grid == null) {
            return -1;
        }

        Queue<Point> queue = new LinkedList();
        //source = validatePoint(source, grid);
        queue.offer(source);
        int step = 0;
        //make sure all the point put in queue is valid point
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Point head = queue.poll();
                printOut(head);
                if(head.x == destination.x && head.y == destination.y) {
                    return step;
                }
                step++;
                Point[] nextSteps = nextSteps(source, grid);
                //System.out.println(nextSteps.length);
                for(Point p : nextSteps) {
                    //System.out.println("running in here" + p);
                    //printOut(p);
                    if(p != null) {
                        queue.offer(p);
                        grid[p.x][p.y] = true;
                    }
                }
            }
        }
        return -1;

    }

    private Point[] nextSteps(Point point, boolean[][] grid) {
        int x = point.x;
        int y = point.y;
        Point[] nextPoints = new Point[8];
        nextPoints[0] = validatePoint(new Point(x + 1, y + 2), grid);
        nextPoints[1] = validatePoint(new Point(x + 1, y - 2), grid);
        nextPoints[2] = validatePoint(new Point(x - 1, y + 2), grid);
        nextPoints[3] = validatePoint(new Point(x - 1, y - 2), grid);
        nextPoints[4] = validatePoint(new Point(x + 2, y + 1), grid);
        nextPoints[5] = validatePoint(new Point(x + 2, y - 1), grid);
        nextPoints[6] = validatePoint(new Point(x - 2, y + 1), grid);
        nextPoints[7] = validatePoint(new Point(x - 2, y - 1), grid);

        return nextPoints;
    }

    /**
     * return null if the point has barries or out of bound
     */
    private Point validatePoint(Point point, boolean[][] grid) {
        if(point.x < 0 || point.x > grid.length - 1) {
            //System.out.println("1");
            return null;
        }
        //System.out.println("the lenght is " + grid[0].length);
        if(point.y < 0 || point.y > grid[0].length - 1) {
            //System.out.println("point y" + point.y);
            return null;
        }
        if(grid[point.x][point.y]==false) {
            return point;
        }
        return null;
    }

    private void printOut(Point p) {
        System.out.println("[" + p.x + "," + p.y + "]");
    }
}


/**
* 本参考程序来自九章算法，由 @九章算法 提供。版权所有，转发请注明出处。
* - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
* - 现有的面试培训课程包括：九章算法班，系统设计班，算法强化班，Java入门与基础算法班，Android 项目实战班，
* - Big Data 项目实战班，算法面试高频题班, 动态规划专题班
* - 更多详情请见官方网站：http://www.jiuzhang.com/?source=code
*/

public class Solution {
    int n, m; // size of the chessboard
    int[] deltaX = {1, 1, 2, 2, -1, -1, -2, -2};
    int[] deltaY = {2, -2, 1, -1, 2, -2, 1, -1};
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        n = grid.length;
        m = grid[0].length;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.x == destination.x && point.y == destination.y) {
                    return steps;
                }

                for (int direction = 0; direction < 8; direction++) {
                    Point nextPoint = new Point(
                        point.x + deltaX[direction],
                        point.y + deltaY[direction]
                    );

                    if (!inBound(nextPoint, grid)) {
                        continue;
                    }

                    queue.offer(nextPoint);
                    // mark the point not accessible
                    grid[nextPoint.x][nextPoint.y] = true;
                }
            }
            steps++;
        }

        return -1;
    }

    private boolean inBound(Point point, boolean[][] grid) {
        if (point.x < 0 || point.x >= n) {
            return false;
        }
        if (point.y < 0 || point.y >= m) {
            return false;
        }
        return (grid[point.x][point.y] == false);
    }
}

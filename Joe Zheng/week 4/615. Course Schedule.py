from collections import deque


class Solution:
    """
    @param: numCourses: a total of n courses
    @param: prerequisites: a list of prerequisite pairs
    @return: true if can finish all courses or false
    """

    def canFinish(self, numCourses, prerequisites):
        # write your code here。
        if numCourses == None or prerequisites == None or numCourses <= 0:
            return True

        # 统计所有点的入度，并初始化拓扑序列为空。
        edges = {i: [] for i in range(numCourses)}
        indegree = [0 for _ in range(numCourses)]

        # 每一段preqeruisite只是2个，是一个pair
        # 在有向图中，如果存在一条有向边 A-->B，那么我们认为这条边为 A 增加了
        # 一个出度，为 B 增加了一个入度
        # 先完成prere再完成course，所有是 preRe --> course
        for course, preRe in prerequisites:
            edges[preRe].append(course)
            indegree[course] += 1

        queue = deque()

        # 将所有入度为 0 的点，也就是那些没有任何依赖的点，
        # 放到宽度优先搜索的队列中
        for n in range(numCourses):
            # no dependent courses
            if indegree[n] == 0:
                queue.append(n)

        count = 0
        # 将队列中的点一个一个的释放出来，放到拓扑序列中，每次释放出某个点 A
        # 的时候，就访问 A 的相邻点（所有A指向的点），并把这些点的入度减去 1。
        while queue:
            course = queue.popleft()
            count += 1
            for edge in edges[course]:
                indegree[edge] -= 1
                # 如果发现某个点的入度被减去 1 之后变成了 0，则放入队列中。
                if indegree[edge] == 0:
                    queue.append(edge)
        # 直到队列为空时，算法结束，
        return count == numCourses

# 2
# [[1,0]]

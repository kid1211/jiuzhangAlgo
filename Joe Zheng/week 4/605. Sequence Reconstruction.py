class Solution:
    """
    @param org: a permutation of the integers from 1 to n
    @param seqs: a list of sequences
    @return: true if it can be reconstructed only one or false
    """

    def sequenceReconstruction(self, org, seqs):
        # write your code here
        # 在有向图中，如果存在一条有向边 A-->B，那么我们认为这条边为 A
        # 增加了一个出度，为 B 增加了一个入度。
        # 统计所有点的入度，并初始化拓扑序列为空。
        indegree = collections.defaultdict(int)
        edges = collections.defaultdict(list)
        nodes = set()

        for seq in seqs:
            # add if it is not already in
            nodes |= set(seq)
            for index, num in enumerate(seq):
                if index == 0:
                    continue
                indegree[num] += 1
                edges[seq[index - 1]].append(num)

        # 将所有入度为 0 的点，也就是那些没有任何依赖的点，放到宽度优先搜索
        # 的队列中
        # size is going to be 1, so no need to use queue
        q = [k for k in nodes if indegree[k] == 0]
        ans = []

        # 将队列中的点一个一个的释放出来，放到拓扑序列中，每次释放出某个点
        # A 的时候，就访问 A 的相邻点（所有A指向的点），并把这些点的入度减去 1。
        # limit the width to one
        while len(q) == 1:
            tmp = q.pop()
            ans.append(tmp)
            for edge in edges[tmp]:
                indegree[edge] -= 1
                # 如果发现某个点的入度被减去 1 之后变成了 0，则放入队列中。
                if indegree[edge] == 0:
                    q.append(edge)

        if len(q) > 1:
            return False

        # 直到队列为空时，算法结束，
        return len(nodes) == len(ans) and ans == org

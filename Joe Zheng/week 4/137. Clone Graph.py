"""
Definition for a undirected graph node
class UndirectedGraphNode:
    def __init__(self, x):
        self.label = x
        self.neighbors = []
"""


class Solution:
    """
    @param: node: A undirected graph node
    @return: A undirected graph node
    """

    def cloneGraph(self, node):
        # write your code here
        if node is None:
            return node
        # bfs to get all the points return in set
        nodes = self.bfs(node)

        rtn = {}
        # add all the node first
        for n in nodes:
            rtn[n] = UndirectedGraphNode(n.label)

        # add all the nodes neighbor
        for n in nodes:
            for neighbor in n.neighbors:
                rtn[n].neighbors.append(rtn[neighbor])

        return rtn[node]

    def bfs(self, node):
        # travers the map and coppy them into a set
        q = collections.deque([node])
        # hashset
        visited = set([node])

        while q:
            tmp = q.popleft()
            for tmpNeighbor in tmp.neighbors:
                if tmpNeighbor not in visited:
                    q.append(tmpNeighbor)
                    visited.add(tmpNeighbor)
        return visited

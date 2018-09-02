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


"""
    def cloneGraph(self, node):
        root = node
        if node is None:
            return node

        # use bfs algorithm to traverse the graph and get all nodes.
        nodes = self.getNodes(node)

        # copy nodes, store the old->new mapping information in a hash map
        mapping = {}
        for node in nodes:
            mapping[node] = UndirectedGraphNode(node.label)

        # copy neighbors(edges)
        for node in nodes:
            new_node = mapping[node]
            for neighbor in node.neighbors:
                new_neighbor = mapping[neighbor]
                new_node.neighbors.append(new_neighbor)

        return mapping[root]

    def getNodes(self, node):
        q = collections.deque([node])
        result = set([node])
        while q:
            head = q.popleft()
            for neighbor in head.neighbors:
                if neighbor not in result:
                    result.add(neighbor)
                    q.append(neighbor)
        return result
    """

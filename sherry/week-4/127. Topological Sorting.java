// 127. Topological Sorting
//
// Given an directed graph, a topological order of the graph nodes is defined as follow:
//
// For each directed edge A -> B in graph, A must before B in the order list.
// The first node in the order can be any node in the graph with no nodes direct to it.
// Find any topological order for the given graph.
//
// Example
//
// For graph as follow:
//
// picture
//
// The topological order can be:
//
// [0, 1, 2, 3, 4, 5]
// [0, 2, 3, 1, 5, 4]
// ...
// Challenge
//
// Can you do it in both BFS and DFS?

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // map 用来存储所有节点的入度，这里主要统计各个点的入度
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        for (DirectedGraphNode node : graph) {
          // loop over the neighbors to get count in-degree
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }

        // 初始化拓扑序列为空
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();

        // 把所有入度为0的点，放到BFS专用的队列中
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                q.offer(node);
                result.add(node);
            }
        }

        // 每次从队列中拿出一个点放到拓扑序列里，并将该点指向的所有点的入度减1
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                // 减去1之后入度变为0的点，也放入队列
                if (map.get(n) == 0) {
                    result.add(n);
                    q.offer(n);
                }
            }
        }

        return result;
    }
}

137. Clone Graph

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

How we serialize an undirected graph:

Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

   1
  / \
 /   \
0 --- 2
     / \
     \_/
Example

return a deep copied graph.

Input test data (one parameter per line.)



/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        // set an Arraylist to story neighbors, how to avoid exist points
        // using set to store the points to avoid duplicate?
        // using bfs to get all nodes in a set -> clone all points clone all edges

        //edgeCase
        if(node == null) {
            return null;
        }

        ArrayList<UndirectedGraphNode> nodes = getNodes(node);

        //clone all points,store relaction of new and old nodes
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for(UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }

        //clone all edges
        //for node, -> neighbor get edges
        for(UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return mapping.get(node);

    }
    //bfs->5 min
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList();
        Set<UndirectedGraphNode> set = new HashSet();

        // put first node in the queue
        queue.offer(node);
        //hashmap is unique in memory reference 内存地址
        set.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for(UndirectedGraphNode n : head.neighbors) {
                if(!set.contains(n)) {
                    set.add(n);
                    queue.offer(n);
                }
            }
        }
        return new ArrayList(set);
    }
}

//克隆每一个点和每一个bian deepcopy
//using the known node to find all nodes
//clone all Nodes
//clone all edges
//

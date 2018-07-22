// 69. Binary Tree Level Order Traversal
//
// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
// Example
//
// Given binary tree {3,9,20,#,#,15,7},
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
//
// return its level order traversal as:
//
// [
//   [3],
//   [9,20],
//   [15,7]
// ]
// Challenge
//
// Challenge 1: Using only 1 queue to implement it.
//
// Challenge 2: Use DFS algorithm to do it.

 /**
  * Definition of TreeNode:
  * public class TreeNode {
  *     public int val;
  *     public TreeNode left, right;
  *     public TreeNode(int val) {
  *         this.val = val;
  *         this.left = this.right = null;
  *     }
  * }
  */

 public class Solution {
     /**
      * @param root: A Tree
      * @return: Level order a list of lists of integer
      */
     public List<List<Integer>> levelOrder(TreeNode root) {
         // write your code here
         // diff from tree to graph is in tree, the nodes are in sequence, so we don't need set to track checked nodes
         List<List<Integer>> result = new ArrayList();
         if(root == null) {
             return result;
         }
         //List<List<Integer>> result = new ArrayList();
         Queue<TreeNode> nodeList = new LinkedList();
         nodeList.offer(root);
         while(!nodeList.isEmpty()) {
             //using size to check the level length.
             int size = nodeList.size();
             ArrayList<Integer> level = new ArrayList();
             for(int i = 0; i < size; i++) {
                 TreeNode head = nodeList.poll();
                 level.add(head.val);
                 if(head.left != null) {
                     nodeList.offer(head.left);
                 }
                 if(head.right != null) {
                     nodeList.offer(head.right);
                 }
             }
             result.add(level);
         }
     return result;

     }

 }

public class Solution {
  public List<List<Integer>> levelOrder(TreeNode node) {
    //from last level extend to next levelOrder
    currentLevel = initial first level
    while(currentLevel != empty) {
      for element in currentLevel {
        extend next level
      }
      curnt level  = next level

    }
  }
}
//TODO DFS
//iteration dfs
//There's a level,  put the result in co-level search is still is dfs
// B
private void dfs(TreeNode node, int level, List<List<Integer>>) {
  if (node == null) {
    return;
  }
  if(result.size < level )
}

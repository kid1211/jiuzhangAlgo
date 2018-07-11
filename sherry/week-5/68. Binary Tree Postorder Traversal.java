// 68. Binary Tree Postorder Traversal
//
// Given a binary tree, return the postorder traversal of its nodes' values.
//
// Example
//
// Given binary tree {1,#,2,3},
//
//    1
//     \
//      2
//     /
//    3
//
//
// return [3,2,1].
//
// Challenge
//
// Can you do it without recursion?
//
// Input test data (one parameter per line.)


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
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root, List<Integer> result) {
        if(root==null) {
            return;
        }
        traversal(root.left, result);
        traversal(root.right, result);
        result.add(root.val);
    }
}

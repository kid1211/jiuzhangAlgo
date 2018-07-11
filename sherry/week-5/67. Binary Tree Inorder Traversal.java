// 67. Binary Tree Inorder Traversal
//
// Given a binary tree, return the inorder traversal of its nodes' values.
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
// return [1,3,2].
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
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }

        traversal(root.left, result);
        result.add(root.val);
        traversal(root.right, result);
    }
}

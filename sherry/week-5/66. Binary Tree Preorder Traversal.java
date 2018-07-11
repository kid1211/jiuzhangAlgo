// 66. Binary Tree Preorder Traversal
//
// Given a binary tree, return the preorder traversal of its nodes' values.
//
// Example
//
// Given:
//
//     1
//    / \
//   2   3
//  / \
// 4   5
// return [1,2,4,5,3].
//
// Challenge
//
// Can you do it without recursion?
//
// Input test data (one parameter per line.)

//TODO implement without recursion
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
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        result.add(root.val);
        traversal(root.left, result);
        traversal(root.right, result);
    }
}

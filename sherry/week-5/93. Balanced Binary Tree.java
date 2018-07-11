// 93. Balanced Binary Tree
//
// Given a binary tree, determine if it is height-balanced.
//
// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
// Example
//
// Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}
//
// A)  3            B)    3
//    / \                  \
//   9  20                 20
//     /  \                / \
//    15   7              15  7
// The binary tree A is a height-balanced binary tree, but B is not.

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
    public class ResultType {
        public boolean isBalanced;
        public int depth;
        public ResultType(int depth, boolean isBalanced) {
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
    }
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        ResultType result = maxDepth(root);
        return result.isBalanced;
    }

    private ResultType maxDepth(TreeNode root) {
        if(root == null) {
            return new ResultType(0, true);
        }

        ResultType left = maxDepth(root.left);
        ResultType right = maxDepth(root.right);

        if(left.isBalanced && right.isBalanced && Math.abs(left.depth - right.depth) <=1) {
            return new ResultType(Math.max(left.depth, right.depth) + 1, true);
        }

        return new ResultType(-1, false);
    }
}

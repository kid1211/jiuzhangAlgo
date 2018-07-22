// 900. Closest Binary Search Tree Value
//
// Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
//
// Example
//
// Given root = {1}, target = 4.428571, return 1.

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
    //private TreeNode upperBound, lowerBound;
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        // find lowerBounder and upper bounder using devide-conter
       TreeNode lowerBound = getLowerBound(root, target);
       TreeNode upperBound = getUpperBound(root, target);
       //get closest value
       if(lowerBound == null) {
           return upperBound.val;
       }
       if(upperBound == null) {
           return lowerBound.val;
       }

       if(target - lowerBound.val < upperBound.val - target) {
           return lowerBound.val;
       }
       return upperBound.val;
       //return Math.min(target - lowerBound.val, upperBound.val - target);
    }
    // find the node with the largest value that smaller than target
    private TreeNode getLowerBound(TreeNode root, double target) {
        if(root == null) {
            return null;
        }
        //
        if(root.val == target) {
            return root;
        }
        // find a smaller value if val > target -> left
        if(root.val > target ) {
            return getLowerBound(root.left, target);
        }
        //if root < target, -> right to find if right side has value smaller than target
        TreeNode lowerBoundNode = getLowerBound(root.right, target);
        if(lowerBoundNode != null) {
            return lowerBoundNode;
        }
        return root;
    }

    private TreeNode getUpperBound(TreeNode root, double target) {
        if(root == null) {
            return null;
        }

        if(root.val == target) {
            return root;
        }

        if(root.val < target) {
            return getUpperBound(root.right, target);
        }

        TreeNode upperBoundNode = getUpperBound(root.left, target);
        if(upperBoundNode != null) {
            return upperBoundNode;
        }
        return root;
    }
}

// 95. Validate Binary Search Tree
//
// Given a binary tree, determine if it is a valid binary search tree (BST).
//
// Assume a BST is defined as follows:
//
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
// A single node tree is a BST
// Example
//
// An example:
//
//   2
//  / \
// 1   4
//    / \
//   3   5
// The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).

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

    private boolean isValid;
    private TreeNode previorNode;
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
     //TODO: check extra ways
    public boolean isValidBST(TreeNode root) {
        // write your code here
        isValid = true;
        previorNode = null;
        inorderTraverse(root);
        return isValid;
    }

    private void inorderTraverse(TreeNode root) {
        if(root == null) {
            return;
        }
        inorderTraverse(root.left);
        if(previorNode != null && previorNode.val >= root.val) {
            isValid = false;
            return;
        }
        previorNode = root;
        inorderTraverse(root.right);
    }
}


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
         boolean isValid;
         TreeNode minNode;
         TreeNode maxNode;

         public ResultType(boolean isValid) {
             this.isValid = isValid;
             minNode = null;
             maxNode = null;
         }
     }
     /**
      * @param root: The root of binary tree.
      * @return: True if the binary tree is BST, or false
      */
      //TODO: check extra ways
     public boolean isValidBST(TreeNode root) {
         // write your code here

         return devideConter(root).isValid;
     }

     private ResultType devideConter(TreeNode root) {
         if(root == null) {
             return new ResultType(true);
         }
         ResultType left = devideConter(root.left);
         ResultType right = devideConter(root.right);
         if(!left.isValid || (left.minNode != null && left.maxNode.val>= root.val)) {
             return new ResultType(false);
         }

         if(!right.isValid || (right.maxNode != null && right.minNode.val <= root.val)) {
             return new ResultType(false);
         }

         // return true;
         ResultType result = new ResultType(true);
         result.minNode = (left.minNode != null ? left.minNode: root);
         result.maxNode = (right.maxNode != null ? right.maxNode: root);
         return result;
     }
 }

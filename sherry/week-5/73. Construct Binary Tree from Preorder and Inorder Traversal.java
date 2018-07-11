// 73. Construct Binary Tree from Preorder and Inorder Traversal
//
// Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Example
//
// Given in-order [1,2,3] and pre-order [2,1,3], return a tree:
//
//   2
//  / \
// 1   3
// Input test data (one parameter per line.)
//

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
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        // need to assume there's no duplicate value
        if(preorder.length != inorder.length) {
            return null;
        }

        TreeNode root = buildMyTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }
    private int findPosition(int[] inorder, int val) {
        for(int i = 0, i < inorder.length; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
    }
    //TODO: question how to ditermin the preEnd
    private TreeNode buildMyTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inorderStart, int inorderEnd) {
        if(inorderStart >= inorderEnd) {
            return;
        }
        // root is always the start of preorder
        TreeNode root = new TreeNode(preorder[preStart]);
        //fint the position of root in preorder
        int position = findPosition(inorder, preorder[preStart]);
        root.left = buildMyTree(preorder, preStart + 1, preStart+ position - inorderStart+1, inorder, inorderStart, position-1 );
        root.right = buildMyTree(preorder, preStart + position - inorderStart, preEnd, inorder, position +1, inorderEnd);
    }
}

//chanllagence-> don;t use pre-order
// use devide conter, save pre-order's last node != null, last node
// root.left = null, root.tight = left.lastnode left,rightnode = root.rightnode

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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        // root.l
        helper(root);
    }
    //the helper method returns the pointer to last node
    private TreeNode helper(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);

        //put root.right = root.left
        //put leftlast.right = root.right;
        if(leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            //NOTE: left need points to null
            root.left = null;
        }

        if(rightLast != null) {
            return rightLast;
        }
        if (leftLast != null) {
            return leftLast;
        }
        return root;

    }
}

import java.util.LinkedList;
import java.util.Queue;

public class DeepCopy {

    /**
     * @param root: The root of binary tree
     * @return: root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        // write your code here
        if (root == null)
            return null;
        TreeNode clone_root = new TreeNode(root.val);
        clone_root.left = cloneTree(root.left);
        clone_root.right = cloneTree(root.right);
        return clone_root;
    }


}

class TreeNode {
    int val;
    TreeNode left, right;
    public  TreeNode (int val) {
        this.val = val;
    }
}
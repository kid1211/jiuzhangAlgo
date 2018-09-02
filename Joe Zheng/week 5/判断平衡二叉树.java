public class Solution {

    // 取巧的方法
    private int NOT_BALANCED = -1;

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != NOT_BALANCED;
    }

    // 1. 平衡就return高度，不平衡就return不平衡
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if (left == NOT_BALANCED || right == NOT_BALANCED) {
            return NOT_BALANCED;
        }

        if (Math.abs(left - right) > 1) {
            return NOT_BALANCED;
        }

        return Math.max(left, right) + 1;
    }
}

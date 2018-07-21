public class Solution {

    // 遍历法是全部走一遍然后找到最大，有点像数组最大值
    private int depth;

    public int maxDepth(TreeNode root) {
        depth = 0;

        traverse(root, 1);
        // 打擂台
        return depth;
    }

    private void traverse(TreeNode node, int currentDepth) {
        if (node == null) {
            return;
        }

        depth = Math.max(depth, currentDepth);
        traverse(node.left, curtDepth + 1);
        traverse(node.right, curtDepth + 1);
    }

    // 分治法 是看看他们两个之间有没有什么不一样的关系
    // return value 这通常来说最大的区别
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 有点像后续遍历
        // 先得到左后儿子
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
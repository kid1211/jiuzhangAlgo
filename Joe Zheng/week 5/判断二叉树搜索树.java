public class Solution {

    // traverse
    private TreeNode lastNode;
    private boolean isValud;

    public boolean isValidBST(TreeNode root) {
        // 中序遍历是一个升序
        isValid = true;
        lastNode = null;

        inorderTraverse(root);
        return isValid;
    }

    private void inorderTRaverse(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraverse(root.left);
        if(lastNode != null && lastNode.val >= root.val) {
            isValid = false;
            return;
        }

        lastNode = root;
        inorderTraverse(root.right);
    }

    // 分治法
    class ResultType {
        public boolean isBST;
        // public int maxValue, minValue;//空就会很尴尬
        public TreeNode maxNode, minNode;
        public ResultType(boolean isBST) {
            this.isBST = isBST;
            this.maxNode = null;
            this.minNode = null;
        }
    }
    public boolean isValidBST(TreeNode root) {
        //divide concuqre
        return divideCoinquer(root).isBST;
    }
    private REsultType divideConquer(TreeNode root) {
        if (root == null) {
            return new ResultType(true);
        }

        ResultType left = divideConquer(root.left);
        ResultType right = divideConquer(root.right);

        if(!left.isBST || !right.isBST) {
            return new ResultType(false);
        }

        if(left.maxNode != null && left.maxNode >= root.val) {
            return new ResultType(false);
        }

        if(right.minNode != null && right.minNode<= root.val) {
            return new ResultType(false);
        }

        //isBST
        ResultType result = new ResultType(true);
        result.minNode = left.minNode != null ? left.minNode : root;
        result.maxNode = right.maxNode != null ? left.minNode : root;

        return result;
    }
}

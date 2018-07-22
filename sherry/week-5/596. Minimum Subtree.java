596. Minimum Subtree

Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

Example

Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   2 -4  -5
return the node 1.

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
//
public class Solution {
    private TreeNode minNode = null;
    private int minSum;
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        //get mim value -> until root ==null
        minSum = Integer.MAX_VALUE;
        helper(root);
        return minNode;
    }

    private int helper(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int sum = helper(node.left) + helper(node.right) + node.val;
        if(sum <= minSum){
          //battle
          minNode = node;
          minSum = sum;
        }
        return sum;
    }
}

//use pre-order in-order post-order to get the sum
// getSum O(n)
// for node in tree {
// getSum }// O(n^2)
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
    //set resultType
    class ResultType {
        TreeNode minNode;
        int minSum, sum;
        ResultType(TreeNode minNode, int minSum, int sum) {
            this.minNode = minNode;
            this.minSum = minSum;
            this.sum = sum;
        }
    }
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        ResultType result = helper(root);
        return result.minNode;
    }

    private ResultType helper(TreeNode root) {
        if(root == null) {
            return new ResultType(null, Integer.MAX_VALUE, 0);
        }

        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);
        ResultType result = new ResultType(
            root,
            leftResult.sum + rightResult.sum + root.val,
            //Q, why minValue is equals to sum?
            leftResult.sum + rightResult.sum + root.val);
        //validate the reslt set to return
        if(leftResult.minSum <= result.minSum) {
            result.minSum = leftResult.minSum;
            result.minNode = leftResult.minNode;
        }
        if (rightResult.minSum <= result.minSum) {
            result.minSum = rightResult.minSum;
            result.minNode = rightResult.minNode;
        }

        return result;
    }

}

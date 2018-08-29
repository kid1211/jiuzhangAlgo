import com.jiuzhang.model.TreeNode;

public class SubTreeRelated {

	private TreeNode subtree = null;
	private ResultType subtreeResult = null;

	public TreeNode findSubtree2(TreeNode root) {
		helper(root);
		return subtree;
	}

	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(0, 0);
		}

		ResultType left = helper(root.left);
		ResultType right = helper(root.right);

		ResultType result = new ResultType(
				left.sum + right.sum + root.val,
				left.size + right.size + 1
		);

		if (subtree == null || subtreeResult.sum * result.size < result.sum * subtreeResult.size) {
			subtree = root;
			subtreeResult = result;
		}
		return result;
	}

	private class ResultType {
		public int sum, size;

		public ResultType(int sum, int size) {
			this.size = size;
			this.sum = sum;
		}
	}

}

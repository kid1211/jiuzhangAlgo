"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""


class Solution:
    minSumRoot = None
    minSum = float('inf')
    """
    @param root: the root of binary tree
    @return: the root of the minimum subtree
    """

    def findSubtree(self, root):
        # write your code here
        if root is None:
            return None

        CurtSum, CurtRoot = self.findSubTreeSum(root, root)
        if CurtSum < self.minSum:
            self.minSum = CurtSum
            self.minSumRoot = CurtRoot
        self.findSubtree(root.left)
        self.findSubtree(root.right)
        return self.minSumRoot
    # return currentSum
    # return depth

    def findSubTreeSum(self, root, CurtRoot):
        if root is None:
            return 0, CurtRoot

        Sum = root.val

        left, _ = self.findSubTreeSum(root.left, CurtRoot)
        if left is not None:
            Sum += left

        right, _ = self.findSubTreeSum(root.right, CurtRoot)
        if right is not None:
            Sum += right

        return Sum, CurtRoot


# {1,-5,2,1,2,-4,-5}
# {1,-1,2,1,2,-4,-5}
# {}

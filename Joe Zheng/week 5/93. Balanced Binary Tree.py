"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param root: The root of binary tree.
    @return: True if this Binary tree is Balanced, or false.
    """
    def isBalanced(self, root):
        # write your code here
        isBalancedTree, _ = self.getTreeHeight(root)
        return isBalancedTree
    def getTreeHeight(self, root):
        # get left height
        # get right height
        # compare
        if root is None:
            return True, 0
        isBalancedTree, left = self.getTreeHeight(root.left)
        if not isBalancedTree:
            return False, 0
        isBalancedTree, right = self.getTreeHeight(root.right)
        if not isBalancedTree:
            return False, 0
        
        return abs(left - right) <= 1, max(left,right) + 1

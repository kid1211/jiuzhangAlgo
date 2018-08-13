"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param root: the given BST
    @param k: the given k
    @return: the kth smallest element in BST
    """
    def kthSmallest(self, root, k):
        # write your code here
        self.TreeValueList = []
        self.helper(root)
        
        return self.TreeValueList[k - 1]
    def helper(self, root):
        if root is None:
            return
        
        self.helper(root.left)
        self.TreeValueList.append(root.val)
        self.helper(root.right)
        
        

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
    @return: True if the binary tree is BST, or false
    """
    def isValidBST(self, root):
        # write your code here
        self.lastVal = None
        self.isBST = True
        self.inorder(root)
        return self.isBST
    # inorder, left to right
    def inorder(self, root):
        if root is None:
            return
        
        self.inorder(root.left)
        if self.lastVal is not None and self.lastVal >= root.val:
            self.isBST = False
            return
        self.lastVal = root.val
        self.inorder(root.right)

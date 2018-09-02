"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""


class Solution:
    """
    @param: root: The root of the binary tree.
    @param: A: A TreeNode
    @param: B: A TreeNode
    @return: Return the LCA of the two nodes.
    """
    def lowestCommonAncestor3(self, root, A, B):
        # write your code here
        isAExist, isBExist, lca = self.helper(root, A, B)
        if isAExist and isBExist:
            return lca
        return None
    def helper(self, root, A, B):
        # subtree
        if root is None:
            return False, False, None
        
        isLeftA, isLeftB, left_node = self.helper(root.left, A, B)
        isRightA, isRightB, right_node = self.helper(root.right, A, B)
        
        isAExist = isLeftA or isRightA or root == A
        isBExist = isLeftB or isRightB or root == B
        
        if root == A or root == B:
            return isAExist, isBExist, root
        
        
        if left_node is not None and right_node is not None:
            return isAExist, isBExist, root
        if left_node is not None:
            return isAExist, isBExist, left_node
        if right_node is not None:
            return isAExist, isBExist, right_node
        
        return isAExist, isBExist, None
            
            
        
        
        

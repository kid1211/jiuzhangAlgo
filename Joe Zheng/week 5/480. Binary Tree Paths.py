"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param root: the root of the binary tree
    @return: all root-to-leaf paths
    """
    def binaryTreePaths(self, root):
        # write your code here
        result = []
        if root is None:
            return result
        self.helper(root, result, [])
        return result
    def helper(self, node, result, currentPath):
        currentPath.append(str(node.val))
        
        # reach the end, add it to result
        if node.left is None and node.right is None:
            result.append('->'.join(currentPath))
            currentPath.pop()
            return
        
        if node.left:
            self.helper(node.left, result, currentPath)
        
        if node.right:
            self.helper(node.right, result, currentPath)
        # finish both left and right, pop, and move on
        currentPath.pop()

# {1,2,3,#,5}
# {}

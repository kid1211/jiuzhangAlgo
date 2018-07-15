"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""


class Solution:
    """
    @param root: A Tree
    @return: Level order a list of lists of integer
    """

    def levelOrder(self, root):
        # write your code here
        # exponetinally grow

        
        """
        @param currentLevel: interger indicate how current level
        @return: Boolean indicate you hit the bottom
        """
        def appendElements(currentLevel):
            
        

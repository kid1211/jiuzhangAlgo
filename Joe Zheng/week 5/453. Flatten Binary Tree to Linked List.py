"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param root: a TreeNode, the root of the binary tree
    @return: nothing
    """
    def flatten(self, root):
        # write your code here
        # create a stack
        if root is None:
            return
        
        self.flatten(root.left)
        self.flatten(root.right)
        
        tmp = root
        if tmp.left is None:
            return

        # left most        
        tmp = tmp.left
        # left tree last right
        while tmp.right:
            tmp = tmp.right
        # put root right to the current.right, but cause current is the next one
        tmp.right = root.right
        # switch from left to right and remove left
        root.right = root.left
        root.left = None
              
            
# {}
# {1,#,2,#,4,#,5,#,3,#,6}
# {1,#,2,4,#,#,5,#,3,#,6}
# {1,#,2,4,#,7,5,#,3,#,6}
# {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
# {98,97,#,88,#,84,#,79,87,64,#,#,#,63,69,62,#,#,#,30,#,27,59,9,#,#,#,3,#,0,#,-4,#,-16,#,-18,-7,-19,#,#,#,-23,#,-34,#,-42,#,-59,#,-63,#,-64,#,-69,#,-75,#,-81}

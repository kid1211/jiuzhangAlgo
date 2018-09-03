"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None

Example of iterate a tree:
iterator = BSTIterator(root)
while iterator.hasNext():
    node = iterator.next()
    do something for node 
"""


class BSTIterator:
    """
    @param: root: The root of binary tree.
    """

    def __init__(self, root):
        # do intialization if necessary
        # find the smallest value and set it to root
        self.stack = []
        self.curt = root

    """
    @return: True if there has next node, or false
    """

    def hasNext(self):
        # write your code here
        return self.curt is not None or len(self.stack) is not 0
    """
    @return: return next node
    """

    def next(self):
        # write your code here
        # inorder traver
        # put all the left in the stack and pop them reversely
        while self.curt is not None:
            self.stack.append(self.curt)
            self.curt = self.curt.left

        self.curt = self.stack.pop()
        res = self.curt
        self.curt = self.curt.right
        return res

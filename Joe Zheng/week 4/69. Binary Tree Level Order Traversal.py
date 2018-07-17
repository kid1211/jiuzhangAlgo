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
        results = []

        if root == None:
            return results

        queue = [root]
        while len(queue) > 0:
            currentLevelResult = []
            size = len(queue)
            for i in range(size):
                currentRoot = queue.pop(0)
                # print (currentRoot.val)
                currentLevelResult.append(currentRoot.val)
                if currentRoot.left != None:
                    queue.append(currentRoot.left)
                if currentRoot.right != None:
                    queue.append(currentRoot.right)
            results.append(currentLevelResult)
        return results

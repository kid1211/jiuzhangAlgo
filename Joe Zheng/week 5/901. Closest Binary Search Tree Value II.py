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
    @param target: the given target
    @param k: the given k
    @return: k values in the BST that are closest to the target
    """

    def closestKValues(self, root, target, k):
        # write your code here
        if k == 0:
            return []

        treeNodes = []
        self.inorder(root, treeNodes)
        # print(treeNodes)
        n = len(treeNodes)
        for i in range(n):
            if treeNodes[i] >= target:
                break

        if i >= n:
            return treeNodes[-k]

        left, right = i - 1, i
        res = []
        for _ in range(k):
            if (left >= 0 and (right >= n or
                               abs(target - treeNodes[left]) <= abs(target - treeNodes[right]))):
                res.append(treeNodes[left])
                left -= 1
            else:
                res.append(treeNodes[right])
                right += 1

        return res
    # inorder traverse to stick it into array

    def inorder(self, root, treeNodes):
        if root is None:
            return
        self.inorder(root.left, treeNodes)
        treeNodes.append(root.val)
        self.inorder(root.right, treeNodes)

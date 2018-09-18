"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""


class Solution:
    """
    @param list1: one of the given list
    @param list2: another list
    @return: the new sorted list of interval
    """

    def mergeTwoInterval(self, list1, list2):
        # write your code here
        res = []
        self.dfs(list1, list2, res)
        return res

    def dfs(self, list1, list2, res):
        if len(list1) <= 0:
            for item in list2:
                self.merge(item, item, res)
            return
        if len(list2) <= 0:
            for item in list1:
                self.merge(item, item, res)
            return

        i1 = list1[0]
        i2 = list2[0]

        if i1.end < i2.start:
            self.merge(i1, i1, res)
            self.dfs(list1[1:], list2, res)
            return

        if i2.end < i1.start:
            self.merge(i2, i2, res)
            self.dfs(list1, list2[1:], res)
            return

        self.merge(i1, i2, res)
        self.dfs(list1[1:], list2[1:], res)
        return

    def merge(self, i1, i2, res):
        start = min(i1.start, i2.start)
        end = max(i1.end, i2.end)

        if len(res) > 0:
            lastRes = res[-1]
            if start <= lastRes.end:
                start = min(start, lastRes.start)
                end = max(end, lastRes.end)
                res.pop()
        res.append(Interval(start, end))

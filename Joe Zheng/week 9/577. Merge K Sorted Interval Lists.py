"""
Definition of Interval.
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""
from heapq import heappush, heappop 
class Solution:
    """
    @param intervals: the given k sorted interval lists
    @return:  the new sorted interval list
    """
    def mergeKSortedIntervalLists(self, intervals):
        # write your code here
        result = []
        heap = []
        
        for index, val in enumerate(intervals):
            if len(val) <= 0:
                continue
            
            heappush(heap, ((val[0].start, val[0].end), index, 0))
        
        while heap:
            curt, x, y = heappop(heap)            
            if len(result) <= 0:
                result.append(Interval(curt[0], curt[1]))
                continue
            lastRes = (result[-1].start, result[-1].end)
            print(lastRes)
            print(curt)
            print('\n')
            if lastRes[1] <= curt[1] and curt[0] >= curt[0]:
                result.pop()
                curt = min(curt[0], lastRes[0]), max(curt[1], lastRes[1])
            
            result.append(Interval(curt[0], curt[1]))
            
            if y + 1 >= len(intervals[x]):
                continue
            nextInt = intervals[x][y + 1]
            heappush(heap, ((nextInt.start, nextInt.end), x, y + 1))
        
        return result
        

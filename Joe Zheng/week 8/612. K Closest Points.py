"""
Definition for a point.
class Point:
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b
"""
import math
class Solution:
    """
    @param points: a list of points
    @param origin: a point
    @param k: An integer
    @return: the k closest points
    """
    def kClosest(self, points, origin, k):
        # write your code here
        from heapq import heappush, heappop
        h = []
        i = 0
        for p in points:
            i+=1
            distant = abs(p.x - origin.x)**2 + abs(p.y - origin.y)**2 
            heappush(h,(math.sqrt(distant), p.x, p.y, i, p))
        
        res = []
        for i in range(k):
            _,_,_,_,p = heappop(h)
            res.append(p)
        
        return res

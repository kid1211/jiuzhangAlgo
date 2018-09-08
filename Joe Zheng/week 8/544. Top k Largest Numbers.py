class Solution:
    """
    @param nums: an integer array
    @param k: An integer
    @return: the top k largest numbers in array
    """
    def topk(self, nums, k):
        # write your code here
        if not nums:
            return []
        from heapq import heappush, heappop
        h = []
        
        for p in nums:
            heappush(h,p)
            if len(h) > k:
                heappop(h)
        return sorted(h, reverse=True)

import heapq

class Solution:
    """
    @param arrays: k sorted integer arrays
    @return: a sorted array
    """
    # @param {int[][]} arrays k sorted integer arrays
    # @return {int[]} a sorted array
    def mergekSortedArrays(self, arrays):
        result = []
        heap = []
        
        for index,val in enumerate(arrays):
            if len(val) <= 0:
                continue
            heapq.heappush(heap, (val[0], index, 0))
            
        
        while (heap):
            val, x, y = heapq.heappop(heap)
            result.append(val)
            
            if y + 1 < len(arrays[x]):
                heapq.heappush(heap, (arrays[x][y + 1], x, y+1))
            
        return result
            

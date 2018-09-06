
class Solution:
    """
    @param n: An integer
    @return: the nth prime number as description.
    """
    def nthUglyNumber(self, n):
        # write your code here
        # construct the tree,
        # then tree traverse
        if n == 1:
            return 1
        from heapq import heappush, heappop
        n -= 1
        key = [2, 3, 5]
        h = []
        
        for i in range(3):
            heappush(h, (key[i], i) )

        value = key[0]
    
        while n > 0:
            # print (h)
            value, level = heappop(h)
            while level < 3:
                new_value = key[level] * value
                heappush(h, (new_value, level))
                level += 1
            n -= 1
        return value

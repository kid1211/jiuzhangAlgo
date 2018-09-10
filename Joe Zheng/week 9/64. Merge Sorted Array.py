class Solution:
    """
    @param: A: sorted integer array A which has m elements, but size of A is m+n
    @param: m: An integer
    @param: B: sorted integer array B which has n elements
    @param: n: An integer
    @return: nothing
    """
    def mergeSortedArray(self, A, m, B, n):
        # write your code here
        a, b = m - 1, n - 1
        idx = m + n -1
        
        while a >= 0 and b >= 0:
            if A[a] > B[b]:
                A[idx] = A[a]
                a -= 1
            else:
                A[idx] = B[b]
                b -= 1
            idx -= 1
        # print(a)
        # print(b)
        # print(A[:b])
        # print(B[:b])
        if b >= 0:
            A[:b + 1] = B[:b + 1]

# [1,2,3]
# 3
# [4,5]
# 2

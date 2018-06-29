class Solution:
    """
    @param: A: An integers array.
    @return: return any of peek positions.
    """

    def findPeak(self, A):
        # write your code here
        if(A[1] > A[2]):
            return 1
        if(A[len(A) - 2] > A[len(A) - 3]):
            return len(A) - 2

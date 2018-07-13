class Solution:
    """
    @param: A: An integers array.
    @return: return any of peek positions.
    """

    def findPeak(self, A):
        # write your code here
        if(A[2] < A[1]):
            return 1
        m = len(A)
        if(A[m - 2] > A[m - 3]):
            return m - 2

        start = 3
        end = m - 3

        while (start + 1 < end):
            mid = start + (end - start) // 2
            # return -mid;
            if (A[mid + 1] < A[mid] and A[mid] > A[mid - 1]):
                return mid

            if(A[mid] > A[start] and A[mid] > A[end]):
                start = mid
            elif(A[mid] < A[start] and A[mid] < A[end]):
                end = mid
            elif(A[start] > A[end]):
                end = mid
            else:
                start = mid

        if (A[start + 1] < A[start] and A[start] > A[start - 1]):
            return start
        if (A[end + 1] < A[end] and A[end] > A[end - 1]):
            return end
        # if(A[start] > A[end]):
        #     return start

        return -182322
# [1,2,1,3,4,5,7,6]
# [100,   102,104,7,9,11,4,   3]
#
# [1,   2,3,4,10,9,5,9,5,9,5,10,9,8,7,   5]
#                      1
# [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0]

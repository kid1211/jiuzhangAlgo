class Solution:
    # @param k & A a integer and an array
    # @return ans a integer
    def kthLargestElement(self, k, A):
        left = 0
        right = len(A) - 1

        while left < right:
            if left >= 0 and A[left] == A[left + 1]:
                left += 1
            if right >= 0 and A[right] == A[right - 1]:
                right -= 1

            if A[left] > A[right]:
                A[left], A[right] = A[right], A[left]
            left += 1
            right -= 1

        print(left)
        print(right)
        if right == k:
            return A[right]
        elif left == k:
            return A[left]
        elif k < right:
            return kthLargestElement(k, A[])

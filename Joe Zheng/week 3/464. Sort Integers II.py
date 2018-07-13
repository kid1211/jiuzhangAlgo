class Solution:
    """
    @param A: an integer array
    @return: nothing
    """

    def sortIntegers2(self, A):
        # write your code here
        # quickSort

        self.quickSort(0, len(A) - 1, A)

    def quickSort(self, start, end, A):
        if start >= end:
            return

        left, right = start, end
        pivot = A[(start + end) // 2]

        while left <= right:
            if A[left] < pivot:
                left += 1
                continue
            if A[right] > pivot:
                right -= 1
                continue

            # if left <= right:
            A[left], A[right] = A[right], A[left]
            left += 1
            right -= 1

        # sort left then right
        # the only lapping part does not need to sort
        self.quickSort(start, right, A)
        self.quickSort(left, end, A)

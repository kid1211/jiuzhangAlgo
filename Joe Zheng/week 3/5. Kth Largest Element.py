class Solution:
    # @param k & A a integer and an array
    # @return ans a integer
    def kthLargestElement(self, k, A):
        length = len(A)
        return self.partitionHelper(0, length - 1, length - k, A)
        # turn the problem into find the len(A) - k smallest

    def partitionHelper(self, start, end, k, A):

        if start > end:
            # sortint done
            print('not ideal')
            return A[k]

        mid = A[(start + end) // 2]
        left, right = start, end
        while left <= right:
            if A[left] < mid:
                left += 1
                continue
            if A[right] > mid:
                right -= 1
                continue

            A[left], A[right] = A[right], A[left]
            left += 1
            right -= 1

        # 3 condition
        if k < right:
            self.partitionHelper(start, right, k, A)
        elif k > left:
            self.partitionHelper(left, end, k - left, A)
        else:
            print(right)
            return A[0]
# 10
# [1,2,3,4,5,6,8,9,10,7]
# 4
# [9,3,2,4,8]

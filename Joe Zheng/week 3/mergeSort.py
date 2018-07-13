# 本参考程序来自九章算法，由 @马克助教 提供。版权所有，转发请注明出处。
# - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
# - 现有的面试培训课程包括：九章算法班，系统设计班，算法强化班，Java入门与基础算法班，Android 项目实战班，
# - Big Data 项目实战班，算法面试高频题班, 动态规划专题班
# - 更多详情请见官方网站：http://www.jiuzhang.com/?source=code


class Solution:
    # @param {int[]} A an integer array
    # @return nothing
    def sortIntegers2(self, A):
        # Write your code here
        temp = [0 for _ in range(len(A))]
        self.merge_sort(0, len(A) - 1, A, temp)

    def merge_sort(self, start, end, A, temp):
        if start >= end:
            return

        mid = (start + end) / 2
        self.merge_sort(start, mid, A, temp)
        self.merge_sort(mid + 1, end, A, temp)
        self.merge(start, mid, end, A, temp)

    def merge(self, start, mid, end, A, temp):
        left, right = start, mid + 1
        index = start
        while left <= mid and right <= end:
            if A[left] < A[right]:
                temp[index] = A[left]
                left += 1
            else:
                temp[index] = A[right]
                right += 1

            index += 1

        while left <= mid:
            temp[index] = A[left]
            left += 1
            index += 1

        while right <= end:
            temp[index] = A[right]
            right += 1
            index += 1

        for index in range(start, end + 1):
            A[index] = temp[index]

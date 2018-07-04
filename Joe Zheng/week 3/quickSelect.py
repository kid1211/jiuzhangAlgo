# 本参考程序来自九章算法，由 @九章算法 提供。版权所有，转发请注明出处。
# - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
# - 现有的面试培训课程包括：九章算法班，系统设计班，算法强化班，Java入门与基础算法班，Android 项目实战班，
# - Big Data 项目实战班，算法面试高频题班, 动态规划专题班
# - 更多详情请见官方网站：http://www.jiuzhang.com/?source=code


class Solution:
    # @param k & A a integer and an array
    # @return ans a integer
    def kthLargestElement(self, k, A):
        n = len(A)
        k -= 1

        def partitionHelper(s, e):
            p, q = s + 1, e
            while p <= q:
                if (A[p] > A[s]):
                    p += 1
                else:
                    A[p], A[q] = A[q], A[p]
                    q -= 1

            A[s], A[q] = A[q], A[s]

            m = q
            if m == k:
                return A[m]
            elif m < k:
                return partitionHelper(m + 1, e)
            else:
                return partitionHelper(s, m - 1)

        return partitionHelper(0, n - 1)

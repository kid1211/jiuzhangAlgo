# 相向双指针


class Solution:
    # @param {int[]} A an integer array
    # @return nothing
    def reverse_while(self, s):
        # Write your code here
        left, right = 0, s.length - 1

        while left < right:
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1

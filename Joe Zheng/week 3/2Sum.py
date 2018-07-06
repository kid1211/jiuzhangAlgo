# 2 sum


class Solution:
    # @param {int[]} A an integer array
    # @return nothing
    def TwoSum_Hash(self, numbers, target):
        # Write your code here
        hash = {}

        for i in range(len(numbers)):
            if target - numbers[i] in hash:
                return [hash[target - numbers[i]], i]
            hash[numbers[i]] = i

        return [-1, -1]

    def TwoSum_For(self, numbers, target):
        for aIndex, a in enumerate(numbers):
            for bIndex, b in enumerate(numbers[aIndex + 1 - len(numbers):]):
                if a + b == target:
                    return [aIndex, bIndex + aIndex + 1]

        return [-1, -1]

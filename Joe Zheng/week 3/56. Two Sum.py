# Given an array of integers, find two numbers such that they add up to a specific target number.

# The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are zero-based.

# Example
# numbers=[2, 7, 11, 15], target=9

# return [0, 1]

# Challenge
# Either of the following solutions are acceptable:

# O(n) Space, O(nlogn) Time
# O(n) Space, O(n) Time

# [2,7,11,15]
# 9
import unittest

# 56. Two Sum
# Given an array of integers, find two numbers such that they add up to a specific target number.

# The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are zero-based.

# Example
# numbers=[2, 7, 11, 15], target=9

# return [0, 1]

# Challenge
# Either of the following solutions are acceptable:

# O(n) Space, O(nlogn) Time
# O(n) Space, O(n) Time


class Solution:
    """
    @param numbers: An array of Integer
    @param target: target = numbers[index1] + numbers[index2]
    @return: [index1, index2] (index1 < index2)
    """

    def twoSum(self, numbers, target):
        # write your code here
        m = len(numbers)

        if(m <= 1):
            return []

        tempNumbers = sorted(numbers)
        left = 0
        right = m - 1

        for _ in range(0, m, 1):
            if target == tempNumbers[left] + tempNumbers[right]:
                firstIndex = numbers.index(tempNumbers[left])
                tempStartLocation = 0
                if tempNumbers[left] == tempNumbers[right]:
                    tempStartLocation = firstIndex + 1
                secondIndex = numbers.index(
                    tempNumbers[right], tempStartLocation)
                return sorted([firstIndex, secondIndex])
            elif target > tempNumbers[left] + tempNumbers[right]:
                left += 1
            else:
                right -= 1
        return -1


class TestCases(unittest.TestCase):
    def testCases(self):
        m = Solution()
        self.failUnlessEqual(m.twoSum([2, 7, 11, 15], 9), [0, 1])
        self.failUnlessEqual(m.twoSum(
            [1, 2, 33, 23, 2423, 33, 23, 1, 7, 6, 8787, 5, 33, 2, 3, -23, -54, -67, 100, 400], 407), [8, 19])

        self.failUnlessEqual(m.twoSum([0, 4, 3, 0], 0), [0, 3])


if __name__ == '__main__':
    unittest.main()

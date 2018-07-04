class Solution:
    """
    @param numbers: Give an array numbers of n integer
    @return: Find all unique triplets in the array which gives the sum of zero.
    """

    def threeSum(self, numbers):
        # assume a>= b >= c => a+b = -c
        if len(numbers) <= 2:
            return []

        numbers.sort()  # a>= b >= c
        rtnArray = []

        for cIndex, negC in enumerate(numbers):
            # TODO: check if it is not equal to zero neccessary?
            if(cIndex != 0 and negC == numbers[cIndex - 1]):
                continue
            # construct an array that doesn't contain c and element prior to c
            for twoSumArray in self.twoSum(numbers[cIndex + 1:], -negC):
                rtnArray.append(twoSumArray)

        return rtnArray

    # @ return: 2 dimention array
    # find all possible 2 sum, not just one
    def twoSum(self, numbers, target):
        lastIndex = len(numbers) - 1
        left = 0
        right = lastIndex
        rtnArray = []

        while(left < right):
            # only proccess when it is the last not repeat element
            if(left != 0 and numbers[left] == numbers[left - 1]):
                left += 1
                continue
            if(right != lastIndex and numbers[right] == numbers[right + 1]):
                right -= 1
                continue
            currentSum = numbers[left] + numbers[right]
            if(currentSum == target):
                rtnThreeSum = [numbers[left], numbers[right], -target]
                # better sort?
                rtnThreeSum.sort()
                rtnArray.append(rtnThreeSum)
                left += 1
                right -= 1
            elif currentSum < target:
                left += 1
            else:
                right -= 1

        print(left, right)
        return rtnArray

# [[-1,0,1]]
# [1,0,-1,-1,-1,-1,0,1,1,1]
# [-2,-3,5,-1,-4,5,-11,7,1,2,3,4,-7,-1,-2,-3,-4,-5]

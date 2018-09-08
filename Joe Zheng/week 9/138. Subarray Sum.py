class Solution:
    """
    @param nums: A list of integers
    @return: A list of integers includes the index of the first number and the index of the last number
    """
    def subarraySum(self, nums):
        # write your code here
        sums = []
        rSum = 0
        for idx,num in enumerate(nums):
            rSum += num
            if rSum == 0:
                return [0, idx]
            sums.append(rSum)
        print(sums)
        length = len(sums)
        for i in range(length):
            for j in range(i + 1,length):
                if sums[j] == sums[i]:
                    # print(i)
                    # print(j)
                    return [i + 1,j]
        return [0,0]

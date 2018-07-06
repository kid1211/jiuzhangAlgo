class TwoSum:
    arrayList = []
    """
    @param: number: An integer
    @return: nothing
    """

    def add(self, number):
        # write your code here
        # use insertion sorted
        # nums = self.arrayList
        # nums.append(number)
        # # second argument is exclude
        # for i in range(len(nums) - 2, -1, -1):
        #     if nums[i] <= nums[i + 1]:
        #         break
        #     nums[i], nums[i + 1] = nums[i + 1], nums[i]

        self.arrayList.append(number)
        # print(self.arrayList)

    """
    @param: value: An integer
    @return: Find if there exists any pair of numbers which sum is equal to the value.
    """

    def find(self, value):
        # write your code here
        hash = {}
        nums = self.arrayList
        for i, num in enumerate(self.arrayList):
            if value - num in hash:
                return True
            hash[num] = i

        return False
        # nums = self.arrayList
        # length = len(nums)
        # left = 0
        # right = length - 1

        # if length <= 1:
        #     return False

        # # cannot use <= because they need to add and get it
        # while left < right:
        #     while left < right and nums[left + 1] == nums[left]:
        #         left += 1
        #     while left < right and nums[right - 1] == nums[right]:
        #         right -= 1

        #     if nums[left] + nums[right] == value:
        #         return True
        #     elif nums[left] + nums[right] > value:
        #         right -= 1
        #     else:
        #         left += 1
        # return False

class TwoSum:
    twoSumArray = []
    """
    @param: number: An integer
    @return: nothing
    """

    def add(self, number):
        # write your code here
        # search the location to insert
        arrayLength = len(self.twoSumArray)
        if(arrayLength <= 0):
            self.twoSumArray.append(number)

        left = 0
        right = arrayLength - 1

        while(left + 1 < right):
            mid = left + (right - left) // 2
            if(self.twoSumArray[mid] == number):
                self.twoSumArray.insert(mid, number)
            elif self.twoSumArray[mid] < number:
                left = mid
            else:
                right = mid

        # print('before')

        # if arrayLength >7:
        #     print([self.twoSumArray[left],self.twoSumArray[right]])
        if number < self.twoSumArray[left]:
            self.twoSumArray.insert(left, number)
        elif number > self.twoSumArray[right]:
            self.twoSumArray.insert(right + 1, number)
        else:
            self.twoSumArray.insert(right, number)
        # return self.twoSumArray
        # print('after')

        # if self.twoSumArray != sorted(self.twoSumArray):
        #     print (number)
        #     print (self.twoSumArray)
    """
    @param: value: An integer
    @return: Find if there exists any pair of numbers which sum is equal to the value.
    """

    def find(self, value):
        # write your code here
        # for x in range(0, 30, 3):/
        posIndex = 0
        negIndex = len(self.twoSumArray) - 1

        while(posIndex + 1 < negIndex):
            currentSum = self.twoSumArray[posIndex] + \
                self.twoSumArray[negIndex]
            if(currentSum == value):
                return True
            elif currentSum < value:
                posIndex += 1
            else:
                negIndex -= 1

        # if posIndex == negIndex:
        currentSum = self.twoSumArray[posIndex] + self.twoSumArray[negIndex]
        if(currentSum == value):
            return True

        return False

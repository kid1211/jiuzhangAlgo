class Solution:
    """
    @param: reader: An instance of ArrayReader.
    @param: target: An integer
    @return: An integer which is the first index of target.
    """

    def searchBigSortedArray(self, reader, target):
        # write your code here
        start = 0
        outOfBound = 2147483647

        while(reader.get(start) < target):
            step = 1
            while(True):

                current = reader.get(start + step)
                prevCurrent = reader.get(start + step - 1)
                if(current == target):
                    if(prevCurrent != target):
                        return start + step
                    else:
                        break
                        # return -9
                if (current == outOfBound or current > target):
                    # return step
                    break
                step *= 2

            if (step < 2):
                return -1

            lastStep = step // 2
            start += lastStep

        # if reader.get(start) == target:
        #     return start
        # elif reader.get(start) == target

        # if(target == 111):
        #     return -7
        return start if reader.get(start) == target else -1

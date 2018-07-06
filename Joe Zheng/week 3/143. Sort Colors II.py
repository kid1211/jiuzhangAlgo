class Solution:
    """
    @param colors: A list of integer
    @param k: An integer
    @return: nothing
    """

    def sortColors2(self, colors, k):
        # write your code here

        # need to break it into half till k is 2 or less than 2
        # need to pass start and end index

        # if k <= 2:
        #     return self.sort2Colors(colors, k)
        self.sort2Colors(colors, 0, len(colors) - 1, k // 2, k)

    def sort2Colors(self, colors, start, end, mid, k):

        # print(colors)
        # print(start)
        # print(end)
        # print(mid)
        # print('\n')

        left = start
        right = end

        while left <= right:
            if colors[left] <= mid:
                left += 1
                continue
            if colors[right] > mid:
                right -= 1
                continue

            colors[left], colors[right] = colors[right], colors[left]
            left += 1
            right -= 1

        # left is the first index of >=k
        # print(left)
        # print(k)
        # print (k//2)
        if mid == 1 or mid == k - 1:
            return
        self.sort2Colors(colors, start, left - 1, mid // 2, k)
        self.sort2Colors(colors, left, end, mid // 2 + mid, k)
# pseduo code
#[2,1,1,2,2]
# 2
# Given colors=[3, 2, 2, 1, 4], k=4

# [3,2,3,3,4,3,3,2,4,4,1,2,1,1,1,3,4,3,4,2]
# 4

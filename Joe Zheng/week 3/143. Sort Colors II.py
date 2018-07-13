class Solution:
    """
    @param colors: A list of integer
    @param k: An integer
    @return: nothing
    """

    def sortColors2(self, colors, k):
        # write your code here
        self.sort2Colors(colors, 0, len(colors) - 1, 1, k)

    def sort2Colors(self, colors, start, end, colorFrom, colorTo):
        # exit situation
        if colorFrom == colorTo:
            return
        if start >= end:
            return

        colorMid = (colorFrom + colorTo) // 2
        left = start
        right = end

        while left <= right:
            if colors[left] <= colorMid:
                left += 1
                continue
            if colors[right] > colorMid:
                right -= 1
                continue

            colors[left], colors[right] = colors[right], colors[left]
            left += 1
            right -= 1

        self.sort2Colors(colors, start, right, colorFrom, colorMid)
        self.sort2Colors(colors, left, end, colorMid + 1, colorTo)

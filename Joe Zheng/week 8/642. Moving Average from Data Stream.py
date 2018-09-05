class MovingAverage:
    """
    @param: size: An integer
    """

    def __init__(self, size):
        # do intialization if necessary
        self.q = collections.deque()
        self.size = size
        self.asum = 0.0

    """
    @param: val: An integer
    @return:  
    """

    def next(self, val):
        # write your code here

        if self.size == len(self.q):
            temp = self.q.popleft()
            self.asum -= temp
        self.asum += val
        self.q.append(val)
        return self.asum / len(self.q)


# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param = obj.next(val)

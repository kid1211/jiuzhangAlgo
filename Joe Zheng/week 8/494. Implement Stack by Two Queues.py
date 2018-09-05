class Stack:
    """
    @param: x: An integer
    @return: nothing
    """

    def __init__(self):
        self.leftQ = []
        self.rightQ = []

    def push(self, x):
        # write your code here

        while len(self.leftQ) > 0:
            self.rightQ.append(self.leftQ.pop())

        return self.leftQ.append(x)

    """
    @return: nothing
    """

    def pop(self):
        # write your code here
        if len(self.leftQ) == 0:
            return self.rightQ.pop()

        while len(self.leftQ) > 1:
            self.rightQ.append(self.leftQ.pop())

        return self.leftQ.pop()

    """
    @return: An integer
    """

    def top(self):
        # write your code here
        if len(self.leftQ) == 0:
            return self.rightQ[-1]
        while len(self.leftQ) > 1:
            self.rightQ.append(self.leftQ.pop())

        return self.leftQ[0]

    """
    @return: True if the stack is empty
    """

    def isEmpty(self):
        # write your code here
        return len(self.leftQ) == 0 and len(self.rightQ) == 0

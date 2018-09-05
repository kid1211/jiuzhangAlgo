class MyQueue:
    
    def __init__(self):
        # do intialization if necessary
        self.s1 = []
        self.s2 = []

    """
    @param: element: An integer
    @return: nothing
    """
    def push(self, element):
        # write your code here
        while len(self.s2) > 0:
            self.s1.append(self.s2.pop())
        self.s1.append(element)

    """
    @return: An integer
    """
    def pop(self):
        # write your code here
        while len(self.s1) > 0:
            self.s2.append(self.s1.pop())
        if len(self.s2) == 0:
            return False
        return self.s2.pop()
    """
    @return: An integer
    """
    def top(self):
        # write your code here
        while len(self.s1) > 0:
            self.s2.append(self.s1.pop())
        if len(self.s2) == 0:
            return False
        return self.s2[-1]


# 1,2,3,4. pop 4, po 3, po s2

class RandomizedSet:
    
    def __init__(self):
        # do intialization if necessary
        self.nums, self.keys = [], {}

    """
    @param: val: a value to the set
    @return: true if the set did not already contain the specified element or false
    """
    def insert(self, val):
        # write your code here
        if val in self.keys:
            return False
        self.nums.append(val)
        self.keys[val] = len(self.nums) - 1
        return True

    """
    @param: val: a value from the set
    @return: true if the set contained the specified element or false
    """
    def remove(self, val):
        # write your code here
        if val in self.keys:
            if len(self.nums) > 1:
                curt, last = self.keys[val], len(self.nums) - 1
                self.keys[self.nums[last]] = curt
                self.nums[curt], self.nums[last] = self.nums[last], self.nums[curt]
            self.nums.pop()
            self.keys.pop(val)
            return True
        return False

    """
    @return: Get a random element from the set
    """
    def getRandom(self):
        # write your code here
        import random
        return self.nums[random.randint(0, len(self.nums) - 1)]

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param = obj.insert(val)
# param = obj.remove(val)
# param = obj.getRandom()

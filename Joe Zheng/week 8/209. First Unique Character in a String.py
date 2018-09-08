class Solution:
    """
    @param str: str: the given string
    @return: char: the first unique character in a given string
    """

    def firstUniqChar(self, str):
        # Write your code here

        char = [0 for i in range(256)]

        for i in str:
            char[ord(i)] += 1

        for i in str:
            if char[ord(i)] == 1:
                return i

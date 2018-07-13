import re


class Solution:
    """
    @param s: A string
    @return: Whether the string is a valid palindrome
    """

    def isPalindrome(self, s):
        # write your code here
        if s == None:
            return False

        if len(s) <= 1:
            return True

        s = re.sub('[^A-Za-z0-9]+', '', s)
        s = s.lower()
        left, right = 0, len(s) - 1

        while left <= right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1

        # [1,2,2,1]
        # [1,2,1]
        return True

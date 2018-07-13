"""
class SVNRepo:
    @classmethod
    def isBadVersion(cls, id)
        # Run unit tests to check whether verison `id` is a bad version
        # return true if unit tests passed else false.
You can use SVNRepo.isBadVersion(10) to check whether version 10 is a 
bad version.
"""


class Solution:
    firstBadVersion = 0
    """
    @param: n: An integer
    @return: An integer which is the first bad version.
    """

    def findFirstBadVersion(self, n):
        # write your code here
        # assume the biggest version is 5000
        if(SVNRepo.isBadVersion(self.firstBadVersion)):
            return self.firstBadVersion
        _i = 1
        for _ in range(n):
            if(SVNRepo.isBadVersion(_i) == True):
                # Do a binar search from i-1 to i
                self.firstBadVersion = _i / 2
                self.findFirstBadVersion(_i)
            _i *= 2
            # print(i)


if __name__ == '__main__':
    Solution().findFirstBadVersion(5)

class Solution:
    """
    @param s: A string 
    @param p: A string includes "?" and "*"
    @return: is Match?
    """

    def isMatch(self, s, p):
        # write your code here
        if s is None or p is None:
            return False
        n = len(s)
        m = len(p)
        self.memo = [[False for _ in range(m)] for _ in range(n)]
        self.visited = [[False for _ in range(m)] for _ in range(n)]
        return self.helper(s, 0, p, 0)

    def helper(self, s, sIndex, p, pIndex):
        # if p reach to the end, s need to reach to the end to be true
        if pIndex == len(p):
            return sIndex == len(s)
        # rest need to be all star to match it, ? won't work because nothing to be mactched
        if sIndex == len(s):
            print('yo')
            return self.allStar(p, pIndex)

        # dp part
        if self.visited[sIndex][pIndex]:
            return self.memo[sIndex][pIndex]

        sChar = s[sIndex]
        pChar = p[pIndex]
        match = None

        if pChar == '*':
            match = self.helper(s, sIndex, p, pIndex +
                                1) or self.helper(s, sIndex + 1, p, pIndex)
        else:
            match = self.charMatch(sChar, pChar) and self.helper(
                s, sIndex + 1, p, pIndex + 1)
        self.visited[sIndex][pIndex] = True
        self.memo[sIndex][pIndex] = match
        return match

    def charMatch(self, sChar, pChar):
        return (sChar == pChar) or pChar == '?'

    def allStar(self, p, pIndex):
        for i in range(pIndex, len(p)):
            if p[i] != '*':
                return False
        return True

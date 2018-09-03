class Solution:
    """
    @param s: A string 
    @param p: A string includes "." and "*"
    @return: A boolean
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
        if len(p) == pIndex:
            return len(s) == sIndex

        if len(s) == sIndex:
            return self.isEmpy(p, pIndex)

        if self.visited[sIndex][pIndex]:
            return self.memo[sIndex][pIndex]

        sChar = s[sIndex]
        pChar = p[pIndex]
        match = None

        # consider a* as a bundle
        if pIndex + 1 < len(p) and p[pIndex + 1] == '*':
            match = self.helper(s, sIndex, p, pIndex + 2) or (
                self.charMatch(sChar, pChar) and self.helper(s, sIndex + 1, p, pIndex))
        else:
            match = self.charMatch(sChar, pChar) and self.helper(
                s, sIndex + 1, p, pIndex + 1)

        self.visited[sIndex][pIndex] = True
        self.memo[sIndex][pIndex] = match
        return match

    def charMatch(self, sChar, pChar):
        return sChar == pChar or pChar == '.'

    def isEmpy(self, p, pIndex):
        for i in range(pIndex, len(p), 2):
            if i + 1 >= len(p) or p[i + 1] is not '*':
                return False
        return True

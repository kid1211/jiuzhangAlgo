class Solution:
    """
    @param pattern: a string,denote pattern string
    @param str: a string, denote matching string
    @return: a boolean
    """

    def wordPatternMatch(self, pattern, str):
        # write your code here
        if pattern is None or str is None:
            return False

        self.dct = {}
        return self.match(pattern, str)

    def match(self, pattern, string):
        # reach to the end of line

        # print(self.dct)
        if len(pattern) == 0:
            return len(string) == 0

        c = pattern[0]
        if c in self.dct:
            if not string.startswith(self.dct[c]):
                # print(string)
                # print(self.dct[c])
                return False
            return self.match(pattern[1:], string[len(self.dct[c]):])

        for sIdx in range(len(string)):
            word = string[:sIdx + 1]
            if word in list(self.dct.values()):
                continue

            self.dct[c] = word
            if self.match(pattern[1:], string[sIdx + 1:]):
                return True
            # print(self.dct)
            # print(c)
            self.dct.pop(c)
        return False

# "d"
# "ef"
# "itwasthebestoftimes"
# "ittwaastthhebesttoofttimes"
# "abab"
# "redblueredblue"

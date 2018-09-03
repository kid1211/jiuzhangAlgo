class Solution:
    """
    @param digits: A digital string
    @return: all posible letter combinations
    """

    def letterCombinations(self, digits):
        # write your code here
        self.letterMap = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz',
        }
        self.res = []
        if not digits:
            return self.res

        self.dfs(digits, [], 0)
        return self.res

    def dfs(self, digits, curt, startIndex):
        if len(digits) == len(curt):
            tmp = ""
            for l in curt:
                tmp += l
            self.res.append(tmp)
            return

        # lettersArray 0 -> digit 0
        # lettersArray 1 -> digit 1
        for l in self.letterMap[digits[startIndex]]:
            curt.append(l)
            self.dfs(digits, curt, startIndex + 1)
            curt.pop()
